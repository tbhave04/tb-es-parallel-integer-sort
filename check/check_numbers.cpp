#include <iostream>

int main() {
    int prev_num = INT_MIN;
    int curr_num;
    while (std::cin >> curr_num) {
        if (curr_num < prev_num) {
            std::cout << "Incorrect." << std::endl;
            return 1;
        }
        prev_num = curr_num;
    }
    std::cout << "Correct." << std::endl;
    return 0;
}