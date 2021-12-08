import pathlib

dayInput = []

def Part1():
  global dayInput

def Part2():
  global dayInput

if __name__ == "__main__":
  dayInput = pathlib.Path("input.txt").read_text().split("\n")
  print("Part 1 answer: " + str(Part1()))
  print("Part 2 answer: " + str(Part2()))