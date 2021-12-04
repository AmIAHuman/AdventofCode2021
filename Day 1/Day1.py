import pathlib

dayInput = []

def Part1():
  global dayInput
  firstNumber = int(dayInput[0])
  secondNumber = -1
  counter = 0
  for index, element in enumerate(dayInput):
    if element == "":
      pass
    elif index != 0:
      secondNumber = int(element)
      counter += (1 if secondNumber > firstNumber else 0)
      firstNumber = secondNumber
  return counter

def Part2():
  global dayInput
  it = iter(dayInput)
  counter = 0
  firstNumber = int(next(it))
  secondNumber = int(next(it))
  thirdNumber = int(next(it))
  firstSum = firstNumber + secondNumber + thirdNumber
  for number in it:
    if number == "":
      pass
    else:
      firstNumber = secondNumber
      secondNumber = thirdNumber
      thirdNumber = int(number)
      secondSum = firstNumber + secondNumber + thirdNumber
      counter += (1 if secondSum > firstSum else 0)
      firstSum = secondSum
  return counter

if __name__ == "__main__":
  dayInput = pathlib.Path("input.txt").read_text().split("\n")
  print("Part 1 answer: " + str(Part1()))
  print("Part 2 answer: " + str(Part2()))