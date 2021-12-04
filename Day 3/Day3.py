import pathlib, collections

dayInput = []

def Part1():
  global dayInput
  commonBits = getCommonBits(dayInput)
  flippedBits = flip(commonBits)
  return int(commonBits, 2) * int(flippedBits, 2)

def flip(bits):
  flippedBits = ""
  for bit in bits:
    flippedBits += ("1" if bit == "0" else "0")
  return flippedBits

def getCommonBits(allBits):
  commonBits = ""
  for index in range(0, len(allBits[0])):
    tmpBits = getCommonBitAt(index, allBits)
    commonBits += "0" if collections.Counter(tmpBits).most_common(1)[0][0] == "0" else "1"
  return commonBits

def getCommonBitAt(index, allBits):
  bitsAtIndex = ""
  for bit in allBits:
    bitsAtIndex += bit[index]
  return bitsAtIndex

def removeNotBitAt(index, bit, allBits):
  keepBits = []
  for bits in allBits:
    if(bits[index] == bit): keepBits.append(bits)
  return keepBits
 
def Part2():
  global dayInput
  copiedInput = dayInput
  secondCopiedInput = dayInput
  oxygenRating = ""
  index = 0
  while len(oxygenRating) != len(dayInput[0]):
    countOne = 0
    countZero = 0
    for bit in getCommonBitAt(index, copiedInput):
      if bit == "0":
        countZero += 1
      elif bit == "1":
        countOne += 1
    commonBit = "1" if countOne >= countZero else "0"
    copiedInput = removeNotBitAt(index, commonBit, copiedInput)
    oxygenRating += commonBit
    index += 1
  index = 0
  while len(secondCopiedInput) > 1:
    notCommon = flip("0" if collections.Counter(getCommonBitAt(index, secondCopiedInput)).most_common(1)[0][0] == "0" else "1")
    secondCopiedInput = removeNotBitAt(index, notCommon, secondCopiedInput)
    index += 1
  return int(oxygenRating, 2) * int(secondCopiedInput[0], 2)


if __name__ == "__main__":
  dayInput = pathlib.Path("input.txt").read_text().split("\n")
  print("Part 1 answer: " + str(Part1()))
  print("Part 2 answer: " + str(Part2()))