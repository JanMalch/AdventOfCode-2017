def next_a(x):
    while True:
        x = x * 16807 % 2147483647
        if x % 4 == 0:
            return x


def next_b(x):
    while True:
        x = x * 48271 % 2147483647
        if x % 8 == 0:
            return x


a = next_a(-1) # start value for A
b = next_b(-1) # start value for B
pairs = 0

for _ in range(5_000_000):
    pairs += int(a & 0xFFFF == b & 0xFFFF)
    a = next_a(a)
    b = next_b(b)

print(pairs)



