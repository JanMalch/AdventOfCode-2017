using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;


namespace ConsoleApp
{
    class Part1
    {
        static void Main(string[] args)
        {
	    string input = "0	2	7	0";

            List<int> numbers = input.Trim().Split(new char[] { '\t' }, StringSplitOptions.RemoveEmptyEntries).Select(str => int.Parse(str)).ToList();
            HashSet<string> seenStates = new HashSet<string>();
            int steps = 0;
            int length = numbers.Count;

            do {
                steps++;
                int remaining = numbers.Max();
                int indexMax = numbers.IndexOf(remaining);
                int incBy = (int) Math.Round((double) remaining / length);

                for (int i = indexMax + 1; i != indexMax && remaining > 0; i++) {
                    if (i == length) { i = 0; }
                    numbers[i] += incBy;
                    remaining -= incBy;
                }
                numbers[indexMax] = remaining;
            } while (seenStates.Add(string.Join(", ", numbers)));
            

            Debug.WriteLine("steps: " + steps);
	}
    }
}