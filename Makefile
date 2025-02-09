all: check_numbers NumberGenerator.class sort/sort_numbers.py
	java input.NumberGenerator | python sort/sort_numbers.py | ./check/check_numbers

check_numbers: check/check_numbers.cpp
	g++ -o check/check_numbers check/check_numbers.cpp

NumberGenerator.class: input/NumberGenerator.java
	javac input/NumberGenerator.java

.PHONY: clean

clean:
	rm check/check_numbers input/NumberGenerator.class
