import pathlib

dayInput = []

def Part1():
  global dayInput
  horizontal = 0
  depth = 0
  for index, element in enumerate(dayInput):
    if element.split(" ")[0] == "forward":
      horizontal += int(element.split(" ")[1])
    elif element.split(" ")[0] == "down":
      depth += int(element.split(" ")[1])
    elif element.split(" ")[0] == "up":
      depth -= int(element.split(" ")[1])
  return horizontal * depth

def Part2():
  global dayInput
  horizontal = 0
  depth = 0
  aim = 0
  for index, element in enumerate(dayInput):
    if element.split(" ")[0] == "forward":
      horizontal += int(element.split(" ")[1])
      depth += aim * int(element.split(" ")[1])
    elif element.split(" ")[0] == "down":
      aim += int(element.split(" ")[1])
    elif element.split(" ")[0] == "up":
      aim -= int(element.split(" ")[1])
  return horizontal * depth

if __name__ == "__main__":
  dayInput = pathlib.Path("input.txt").read_text().split("\n")
  print("Part 1 answer: " + str(Part1()))
  print("Part 2 answer: " + str(Part2()))