import sys


def main():
    nums = map(int, sys.stdin)
    print(sorted(nums), sep="\n")


if __name__ == "__main__":
    main()