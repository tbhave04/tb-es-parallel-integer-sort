# parallel-integer-sort
CDS DE subteam internal competition for the Spring 2025 semester.

In this project, you will be sorting a lot of random 32-bit integers from –2147483648 (-2^32) to 2147483647 (2^31). The integers are not guaranteed to be unique. Get started by running `make`.

## Serial implementation
Write a serial implementation of a sorting algorithm of your choice in a language of your choice. Make sure that your program reads integers from standard input, with each line containing a single integer, and outputs integers in the same format. You are not permitted to use any library sorting functions.

## Parallel implementation
Do the same thing, but with a parallelizable sorting algorithm. You may use the same algorithm as your serial implementation, if that algorithm is parallelizable. The same restrictions on library sorting functions apply.

## Evaluation
Evaluate your parallel sorting implementation and how it compares to your serial implementation. Be sure to test how performance and memory usage varies with `N` (number of integers) and `P` (number of threads).

Please note that `check_numbers.cpp` only checks to see if the integers it reads from standard input are in sorted order. It does not check to see if the integers output by your sorting program are the same as the original generated integers. For your final submission, we will evaluate the correctness, performance, and memory usage of your sorting implementation.
