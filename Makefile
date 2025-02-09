all: check/check_numbers input/NumberGenerator.class sort/sort_numbers
	java input.NumberGenerator | ./sort/sort_numbers | ./check/check_numbers

check/check_numbers: check/check_numbers.cpp
	g++ -o check/check_numbers check/check_numbers.cpp

input/NumberGenerator.class: input/NumberGenerator.java
	javac input/NumberGenerator.java

sort/sort_numbers: sort/sort_numbers.ml
	ocamlc -o sort/sort_numbers sort/sort_numbers.ml

.PHONY: clean

clean:
	rm check/check_numbers **/*.class sort/sort_numbers **/*.cmo **/*.cmi
