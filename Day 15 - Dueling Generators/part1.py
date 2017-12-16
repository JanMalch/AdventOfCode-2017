genA = 277
genB = 349
pairs = 0

for _ in range(40_000_000):
    genA = genA * 16807 % 2147483647
    genB = genB * 48271 % 2147483647
    pairs += int(genA & 0xFFFF == genB & 0xFFFF)

print(pairs)
