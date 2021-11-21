/*
 * Main.cpp
 *
 *  Created on: Fall 2019
 */

#include <stdio.h>
#include <math.h>
#include <CImg.h>

#include <errno.h>
#include <immintrin.h> // Required to use intrinsic functions


// TODO: Example of use of intrinsic functions
// This example doesn't include any code about image processing


#define VECTOR_SIZE      32 // Array size. Note: It is not a multiple of 8
#define ITEMS_PER_PACKET (sizeof(__m256)/sizeof(data_t))

using namespace cimg_library;

// Data type for image components
// FIXME: Change this type according to your group assignment
typedef float data_t ;

const char *SOURCE_IMG = "bailarina.bmp";
const char *DESTINATION_IMG = "bailarinaDestinoSimd.bmp";
const uint REPETICIONES = 20;
bool checkFileExists(const char *filename);

const int EXIT_IMG_SOURCE_ERROR = -1; //Constant for the exiting if source images fail
const int EXIT_IMG_DEST_ERROR = -2;	  //Constant for the exiting if destiny image fails
const data_t CONTRAST_VARIATION_PERCENTAGE = 20;

int main()
{
	//Comprueba que el archivo origen existe
	if (checkFileExists(SOURCE_IMG) == 0)
	{
		printf("El archivo origen no existe");
		exit(EXIT_IMG_SOURCE_ERROR);
	}
	// Open file and object initialization
	CImg<data_t> srcImage(SOURCE_IMG);

    /***************************************************
	 * TODO: Variables initialization.
	 *   - Prepare variables for the algorithm
	 *   - This is not included in the benchmark time
	 */

	srcImage.display();		  // Displays the source image
	width = srcImage.width(); // Getting information from the source image
	height = srcImage.height();
	nComp = srcImage.spectrum(); // source image number of components
								 // Common values for spectrum (number of image components):
								 //  B&W images = 1
								 //	Normal color images = 3 (RGB)
								 //  Special color images = 4 (RGB and alpha/transparency channel)


    // Data arrays to sum. May be or not memory aligned to __m256 size (32 bytes)
    data_t redVector[VECTOR_SIZE], blueVector[VECTOR_SIZE],greenVector[VECTOR_SIZE], contrastVector[VECTOR_SIZE];
    // Calculation of the size of the resulting array
    // How many 256 bit packets fit in the array?
    int nPackets = (VECTOR_SIZE * sizeof(data_t)/sizeof(__m256));

    // If it is not a exact number we need to add one more packet
    if ( ((VECTOR_SIZE * sizeof(data_t))%sizeof(__m256)) != 0) {
        nPackets++;
	}
   
    // Create an array aligned to 32 bytes (256 bits) memory boundaries to store the sum.
    // Aligned memory access improves performance    
    float *pDstImage = (float *)_mm_malloc(sizeof(__m256) * nPackets, sizeof(__m256));
    if (pDstImage == NULL) {
        perror("Allocating destination image");
        exit(EXIT_IMG_DEST_ERROR);
    }

	data_t *pRsrc, *pGsrc, *pBsrc; // Pointers to the R, G and B components
	data_t *pRdest, *pGdest, *pBdest;
	data_t *pDstImage;	// Pointer to the new image pixels
	uint width, height; // Width and height of the image
	uint nComp;			// Number of image components
	struct timespec tStart, tEnd;
	double dElapsedTimeS;

    // 32 bytes (256 bits) packets. Used to stored aligned memory data
    __m256 red, green, blue;

    /*_mm256_mul_epu32 (red,contrast);
    _mm256_mul_epu32 (blue,contrast);
    _mm256_mul_epu32 (green,contrast);*/

    
	// Pointers to the componet arrays of the source image
	pRsrc = srcImage.data();		// pRcomp points to the R component array
	pGsrc = pRsrc + height * width; // pGcomp points to the G component array
	pBsrc = pGsrc + height * width; // pBcomp points to B component array
    data_t T;
	data_t C;
    //Contrast
    T = CONTRAST_VARIATION_PERCENTAGE;
	C = ((100 + T) / 100) * ((100 + T) / 100);
	// Pointers to the RGB arrays of the destination image
	pRdest = pDstImage;
	pGdest = pRdest + height * width;
	pBdest = pGdest + height * width;

    for (int i = 0; i < VECTOR_SIZE; i++) {
        *(redVector + i) = (data_t) *pRsrc;       // a =  0, 1, 2, 3, …
        *(greenVector + i) = (data_t) *pGsrc; // b =  0, 2, 4, 6, …
        *(blueVector + i) = (data_t) *pBsrc; // b =  0, 2, 4, 6, …
        *(contrastVector + i) = (data_t) C; // b =  0, 2, 4, 6, …
    }


    red = _mm256_loadu_ps(redVector);
    green = _mm256_loadu_ps(greenVector);
    blue = _mm256_loadu_ps(blueVector);
    contrast = _mm256_loadu_ps(contrastVector);

    red = _mm256_mul_ps(red, contrast);
    green = _mm256_mul_ps(green, contrast);
    blue = _mm256_mul_ps(blue, contrast);

    for (int i = 0; i < VECTOR_SIZE; i++) {
        _mm256_storeu_pd(pRdest + i,red);
        _mm256_storeu_pd(pGdest + i,green);
        _mm256_storeu_pd(pBdest + i,blue);
    }
    
	/***********************************************
	 * TODO: Algorithm start.
	 *   - Measure initial time
	 */
	printf("Task has started\n");
	if (clock_gettime(CLOCK_REALTIME, &tStart))
	{
		printf("ERROR: clock_gettime: %d.\n", errno);
		exit(EXIT_FAILURE);
	}

	/************************************************
	 * FIXME: Algorithm.
	 * In this example, the algorithm is a components swap
	 *
	 * TO BE REPLACED BY YOUR ALGORITHM
	 */
	
/*
	for (uint i = 0; i < REPETICIONES; i++)
	{
		

		for (uint i = 0; i < width * height; i++)
		{
			*(pRdest + i) = (*(pRsrc + i)) * C;
			if (*(pRdest + i) > 255)
				*(pRdest + i) = 255;
			if (*(pRdest + i) < 0)
				*(pRdest + i) = 0;
			*(pGdest + i) = (*(pGsrc + i)) * C;
			if (*(pGdest + i) > 255)
				*(pGdest + i) = 255;
			if (*(pGdest + i) < 0)
				*(pGdest + i) = 0;
			*(pBdest + i) = (*(pBsrc + i)) * C;
			if (*(pBdest + i) > 255)
				*(pBdest + i) = 255;
			if (*(pBdest + i) < 0)
				*(pBdest + i) = 0;
		}

		for (uint i = 0; i < width * height; i++)
		{

			*(pRdest + i) = *(pRdest + i) * 0.393 + *(pGdest + i) * 0.769 + *(pBdest + i) * 0.189;
			if (*(pRdest + i) > 255)
				*(pRdest + i) = 255;
			if (*(pRdest + i) < 0)
				*(pRdest + i) = 0;
			*(pGdest + i) = *(pRdest + i) * 0.349 + *(pGdest + i) * 0.686 + *(pBdest + i) * 0.168;
			if (*(pGdest + i) > 255)
				*(pGdest + i) = 255;
			if (*(pGdest + i) < 0)
				*(pGdest + i) = 0;
			*(pBdest + i) = *(pRdest + i) * 0.272 + *(pGdest + i) * 0.534 + *(pBdest + i) * 0.131;
			if (*(pBdest + i) > 255)
				*(pBdest + i) = 255;
			if (*(pBdest + i) < 0)
				*(pBdest + i) = 0;
		}
	}*/

	/***********************************************
	 * TODO: End of the algorithm.
	 *   - Measure the end time
	 *   - Calculate the elapsed time
	 */

	if (clock_gettime(CLOCK_REALTIME, &tEnd))
	{
		printf("ERROR: clock_gettime: %d.\n", errno);
		exit(EXIT_FAILURE);
	}
	printf("Task ended.\n");
	dElapsedTimeS = (tEnd.tv_sec - tStart.tv_sec);
	dElapsedTimeS += (tEnd.tv_nsec - tStart.tv_nsec) / 1e+9;
	printf("%.2f segundos\n", dElapsedTimeS);
	// Create a new image object with the calculated pixels
	// In case of normal color images use nComp=3,
	// In case of B/W images use nComp=1.
	CImg<data_t> dstImage(pDstImage, width, height, 1, nComp);
	if (!(srcImage.size() == dstImage.size()))
	{
		printf("El tamaño de las imágenes es distinto \n");
		exit(EXIT_IMG_DEST_ERROR);
	}

	// Store destination image in disk
	dstImage.save(DESTINATION_IMG);

	// Display destination image
	dstImage.display();

	// Free memory
	free(pDstImage);

	return 0;
}

//Funcion que devuelve 1 si el archivo existe, o 0 si no existe
bool checkFileExists(const char *filename)
{
    struct stat buffer;
    int exists = stat(filename, &buffer);
    return exists==0;
}
/*
 * Main.cpp
 *
 *  Created on: Fall 2019
 */
/*
#include <stdio.h>
#include <immintrin.h> // Required to use intrinsic functions


// TODO: Example of use of intrinsic functions
// This example doesn't include any code about image processing


#define VECTOR_SIZE       32 // Array size. Note: It is not a multiple of 8
#define ITEMS_PER_PACKET (sizeof(__m256)/sizeof(data_t))


int main() {

	// Data arrays to sum. May be or not memory aligned to __m256 size (32 bytes)
    data_t a[VECTOR_SIZE], b[VECTOR_SIZE];

    // Calculation of the size of the resulting array
    // How many 256 bit packets fit in the array?
    int nPackets = (VECTOR_SIZE * sizeof(data_t)/sizeof(__m256));

    // If it is not a exact number we need to add one more packet
    if ( ((VECTOR_SIZE * sizeof(data_t))%sizeof(__m256)) != 0) {
        nPackets++;
	}
   
    // Create an array aligned to 32 bytes (256 bits) memory boundaries to store the sum.
    // Aligned memory access improves performance    
    data_t *c = (data_t *)_mm_malloc(sizeof(__m256) * nPackets, sizeof(__m256));

    // 32 bytes (256 bits) packets. Used to stored aligned memory data
    __m256 va, vb; 

    // Initialize data arrays
    for (int i = 0; i < VECTOR_SIZE; i++) {
        *(a + i) = (data_t) i;       // a =  0, 1, 2, 3, …
        *(b + i) = (data_t) (2 * i); // b =  0, 2, 4, 6, …
    }

    // Set the initial c element's value to -1 using vector extensions
    *(__m256 *) c = _mm256_set1_ps(-1);
    *(__m256 *)(c + ITEMS_PER_PACKET)     = _mm256_set1_ps(-1);
    *(__m256 *)(c + ITEMS_PER_PACKET * 2) = _mm256_set1_ps(-1);

    // Data arrays a and b must not be memory aligned to __m256 data (32 bytes)
    // so we use intermediate variables to avoid execution errors.
    // We make an unaligned load of va and vb
    va = _mm256_loadu_ps(a);      // va = a[0][1]…[7] = 0, 1, 2, 3,  4,  5,  6,  7
    vb = _mm256_loadu_ps(b);      // vb = b[0][1]…[7] = 0, 2, 4, 6,  8, 10, 12, 14
    
    // Performs the addition of two aligned vectors, each vector containing 8 data_ts
    *(__m256 *)c = _mm256_add_ps(va, vb);// c = c[0][1]…[7] = 0, 3, 6, 9, 12, 15, 18, 21

    // Next packet
    // va = a[8][9]…[15] =  8,  9, 10, 11, 12, 13, 14, 15
    // vb = b[8][9]…[15] = 16, 18, 20, 22, 24, 26, 28, 30
    //  c = c[8][9]…[15] = 24, 27, 30, 33, 36, 39, 42, 45
    va = _mm256_loadu_ps((a + ITEMS_PER_PACKET)); 
    vb = _mm256_loadu_ps((b + ITEMS_PER_PACKET)); 
    *(__m256 *)(c + ITEMS_PER_PACKET) = _mm256_add_ps(va, vb);

    // If vectors va and vb have not a number of elements multiple of ITEMS_PER_PACKET 
    // it is necessary to differentiate the last iteration. 

    // Calculation of the elements in va and vb in excess
    int dataInExcess = (VECTOR_SIZE)%(sizeof(__m256)/sizeof(data_t));

    // Surplus data can be processed sequentially
    
    for (int i =0; i< dataInExcess; i++){
        *(c + 2 * ITEMS_PER_PACKET + i) = *(a + 2 * ITEMS_PER_PACKET + i) + *(b + 2 * ITEMS_PER_PACKET + i);
    }
    
    // Print resulting data from array addition
    for (int i = 0; i < VECTOR_SIZE; i++) {
        printf("\nc[%d]: %f", i, *(c + i));
	}
  
    // Free memory allocated using _mm_malloc
    // It has to be freed with _mm_free
    _mm_free(c);

	return 0;
}*/