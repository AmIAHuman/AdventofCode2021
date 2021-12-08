import pathlib
from collections import Counter

dayInput = []

def Part1():
  global dayInput
  lanternFishes = Counter(dayInput)

def Part2():
  global dayInput

if __name__ == "__main__":
  dayInput = pathlib.Path("input.txt").read_text().split("\n")[0].split(",")
  print("Part 1 answer: " + str(Part1()))
  print("Part 2 answer: " + str(Part2()))