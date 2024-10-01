int[][] hitPoints = { {4, 6, 8, 10}, {7, 10, 13, 16}, {10, 14, 18, 22} };
for (int level = 0; level < hitPoints.length; ++level) {
    for (int class = 0; class < hitPoints[level].length; ++class) {
        System.out.print(hitPoints[level][class]);
        System.out.print("\t");
    }
    System.out.printf("%n"); // Could also use \n.