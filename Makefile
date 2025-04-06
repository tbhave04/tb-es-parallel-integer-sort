n ?= 10000000
path_serial ?= "java Serial.java"
path_parallel ?= "java Parallel.java"
# usage: make n=[whatever] path=[path to ur sorting executable]
serial: Serial.java
    python3 check.py $(n) $(path_serial)

parallel: Parallel.java
    python3 check.py $(n) $(path_parallel)

sort/sort_numbers: sort/sort_numbers.ml
	ocamlc -o sort/sort_numbers sort/sort_numbers.ml

.PHONY: clean

clean:
	rm check/check_numbers **/*.class sort/sort_numbers **/*.cmo **/*.cmi generate/NumberGenerator.class