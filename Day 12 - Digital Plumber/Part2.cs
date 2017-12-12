using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.IO;
using System.Linq;
using System.Threading.Tasks;

namespace ConsoleApp {
    class Part2 {
		static HashSet<int> reachables = new HashSet<int>();
        static Dictionary<int, int[]> pipes = new Dictionary<int, int[]>();
		
        static void Main(string[] args) {
           string[] input = File.ReadLines("input.txt").ToArray();

            foreach (string line in input) {
                string[] parts = line.Split(new string[] {" <-> "}, StringSplitOptions.RemoveEmptyEntries);

                int key = int.Parse(parts[0]);
                int[] values = Array.ConvertAll(
                    parts[1].Split(new string[] { ", " }, StringSplitOptions.RemoveEmptyEntries), int.Parse);

                pipes.Add(key, values);
            }

            int i = 0;
            foreach (int pipe in pipes.Keys) {
                if (!reachables.Contains(pipe)) {
                    GetReachables(pipe);
                    i++;
                }
            }

            Debug.WriteLine("groups: " + i);
        }

        static void GetReachables(int key) {
            if (reachables.Contains(key)) return;

            reachables.Add(key);
            foreach (int i in pipes[key]) {
                GetReachables(i);
            }
        }
    }
}