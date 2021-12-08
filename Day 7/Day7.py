import pathlib

dayInput = []

def Part1():
  global dayInput
  crabs = list(map(int, dayInput[0].split(",")))
  fuels = []
  for fuel in range(0, max(crabs)):
    fuels.append(alignSum(crabs, fuel))
  return min(fuels)

def alignSum(crabs, fuel):
  sum = 0
  for crab in crabs:
    sum += abs(crab - fuel)
  return sum

def Part2():
  global dayInput
  crabs = list(map(int, dayInput[0].split(",")))
  fuels = []
  for fuel in range(0, max(crabs)):
    fuels.append(alignIncreasingSum(crabs, fuel))
  return min(fuels)

def alignIncreasingSum(crabs, fuel):
  sum = 0
  for crab in crabs:
    sum += getIncreasingSum(abs(crab - fuel))
  return sum

def getIncreasingSum(num):
  sum = 0
  for i in range(1, num + 1):
    sum += i
  return sum

if __name__ == "__main__":
  dayInput = pathlib.Path("input.txt").read_text().split("\n")
  print("Part 1 answer: " + str(Part1()))
  print("Part 2 answer: " + str(Part2()))