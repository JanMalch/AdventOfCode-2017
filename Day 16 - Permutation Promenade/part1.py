dancers = [0] * 16
for i in range(16):
    dancers[i] = chr(ord('a') + i)

dance = open("input.txt", "r").read().strip().split(",")

for move in dance:

    if move.startswith("s"):
        x = int(move[1:]) * -1
        front = dancers[x:]
        dancers = front + dancers[:x]

    elif move.startswith("x"):
        i = int(move[1:].split("/")[0])
        j = int(move[1:].split("/")[1])
        dancers[j], dancers[i] = dancers[i], dancers[j]

    elif move.startswith("p"):
        c, d = move[1:].split("/")
        indC = dancers.index(c)
        indD = dancers.index(d)
        dancers[indC] = d
        dancers[indD] = c

print("".join(dancers))

