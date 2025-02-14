
#include <iostream>
#include <cstring>
using namespace std;

// Class for Question 2a: Check if a number is prime
class Question2a {
public:
    void isPrime() {
        int num, i;
        bool prime = true;
        cout << "Input a number: ";
        cin >> num;
        if (num <= 1) prime = false;
        for (i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                prime = false;
                break;
            }
        }
        if (prime)
            cout << num << " is a prime number\n";
        else
            cout << num << " is not a prime number\n";
    }
};

// Class for Question 2b: Sum of array elements
class Question2b {
public:
    void sumArray() {
        int n, sum = 0;
        cout << "Input the number of elements to be stored in the array: ";
        cin >> n;
        int arr[n];
        cout << "Input " << n << " elements in the array:\n";
        for (int i = 0; i < n; i++) {
            cout << "element-" << i << ": ";
            cin >> arr[i];
            sum += arr[i];
        }
        cout << "Sum of all elements stored in the array is: " << sum << endl;
    }
};

// Class for Question 3a: Bubble Sort
class Question3a {
public:
    void bubbleSort() {
        int n;
        cout << "Input the number of elements to be stored in the array: ";
        cin >> n;
        int arr[n];
        cout << "Input " << n << " elements in the array:\n";
        for (int i = 0; i < n; i++) {
            cout << "element-" << i << ": ";
            cin >> arr[i];
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        cout << "After sorting the array:\n";
        for (int i = 0; i < n; i++) {
            cout << arr[i] << endl;
        }
    }
};

// Class for Question 3b: Sum and Average of 10 numbers
class Question3b {
public:
    void sumAndAverage() {
        int numbers[10], sum = 0;
        cout << "Input the 10 numbers:\n";
        for (int i = 0; i < 10; i++) {
            cout << "Number-" << i + 1 << ": ";
            cin >> numbers[i];
            sum += numbers[i];
        }
        cout << "The sum of 10 numbers is: " << sum << endl;
        cout << "The Average is: " << sum / 10.0 << endl;
    }
};

// Class for Question 4a: String Length
class Question4a {
public:
    void stringLength() {
        const char* text = "Learn C Programming";
        cout << "The length of the string \"" << text << "\" is " << strlen(text) << endl;
    }
};

// Class for Question 4b: Linear Search
class Question4b {
public:
    void linearSearch() {
        int arr[] = {23, 60, 90, 50, 20, 55, 100, 10};
        int key = 50;
        int size = sizeof(arr) / sizeof(arr[0]);
        int position = -1;
        for (int i = 0; i < size; i++) {
            if (arr[i] == key) {
                position = i + 1;
                break;
            }
        }
        if (position != -1)
            cout << "The key " << key << " is at position " << position << endl;
        else
            cout << "The key " << key << " is not found in the array" << endl;
    }
};

// Class for Question 5a: Add Numbers Using Pointers
class Question5a {
public:
    void addNumbers() {
        int a, b;
        cout << "Input the first number: ";
        cin >> a;
        cout << "Input the second number: ";
        cin >> b;
        int* p1 = &a, * p2 = &b;
        cout << "The sum of the entered numbers is: " << *p1 + *p2 << endl;
    }
};

// Class for Question 5b: Check Palindrome
class Question5b {
public:
    void checkPalindrome() {
        int num, reversed = 0, original, remainder;
        cout << "Input a number: ";
        cin >> num;
        original = num;
        while (num != 0) {
            remainder = num % 10;
            reversed = reversed * 10 + remainder;
            num /= 10;
        }
        if (original == reversed)
            cout << "The number is a palindrome number" << endl;
        else
            cout << "The number is not a palindrome number" << endl;
    }
};

// Class for Question 6a: Student Information
class Question6a {
public:
    struct Student {
        string name;
        int age;
        int totalMarks;
    };

    void studentInfo() {
        Student s1, s2;
        cout << "Enter details for first student:\n";
        cout << "Name: "; cin >> s1.name;
        cout << "Age: "; cin >> s1.age;
        cout << "Total Marks: "; cin >> s1.totalMarks;
        cout << "\nEnter details for second student:\n";
        cout << "Name: "; cin >> s2.name;
        cout << "Age: "; cin >> s2.age;
        cout << "Total Marks: "; cin >> s2.totalMarks;

        cout << "\nStudent 1: " << s1.name << ", Age: " << s1.age << ", Marks: " << s1.totalMarks << endl;
        cout << "Student 2: " << s2.name << ", Age: " << s2.age << ", Marks: " << s2.totalMarks << endl;
        cout << "Average Marks: " << (s1.totalMarks + s2.totalMarks) / 2.0 << endl;
    }
};

// Class for Question 6b: Odd/Even and Positive/Negative Check
class Question6b {
public:
    void checkNumber() {
        int num;
        cout << "Input a number (integer): ";
        cin >> num;
        if (num == 0)
            cout << "Zero" << endl;
        else if (num > 0 && num % 2 == 0)
            cout << "Number is positive even" << endl;
        else if (num > 0)
            cout << "Number is positive odd" << endl;
        else if (num % 2 == 0)
            cout << "Number is negative even" << endl;
        else
            cout << "Number is negative odd" << endl;
    }
};

// Class for Question 7a: Factorial Using Recursion
class Question7a {
public:
    int factorial(int n) {
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }

    void calculateFactorial() {
        int num;
        cout << "Input the number: ";
        cin >> num;
        cout << "The Factorial of " << num << " is: " << factorial(num) << endl;
    }
};

// Class for Question 7b: Personal Information
class Question7b {
public:
    void printInfo() {
        cout << "Name: Alexandra Abramov\n";
        cout << "DOB: July 14, 1975\n";
        cout << "Mobile: 99-9999999999\n";
    }
};

// Main Function
int main() {
    Question2a q2a; q2a.isPrime();
    Question2b q2b; q2b.sumArray();
    Question3a q3a; q3a.bubbleSort();
    Question3b q3b; q3b.sumAndAverage();
    Question4a q4a; q4a.stringLength();
    Question4b q4b; q4b.linearSearch();
    Question5a q5a; q5a.addNumbers();
    Question5b q5b; q5b.checkPalindrome();
    Question6a q6a; q6a.studentInfo();
    Question6b q6b; q6b.checkNumber();
    Question7a q7a; q7a.calculateFactorial();
    Question7b q7b; q7b.printInfo();

    return 0;
}
