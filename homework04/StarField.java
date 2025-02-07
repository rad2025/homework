// Delta College - CST 283 - Klingler
// This class utilizes a two-dimensional array to store
// the light intensities of a star field.

import java.io.*;
import java.util.Scanner;

public class StarField
{
    private final int MAXROWS = 6;
    private final int MAXCOLS = 8;

    private int starData[][];
    private String starMarkers[][];

    // This function builds an array of digitized star data
    // from a data file
    public StarField(String starFileName)
    {
        starData = new int[MAXROWS][MAXCOLS];
        try
        {
            File inFileRef = new File(starFileName);
            Scanner inputFile = new Scanner(inFileRef);

            // Read-process-write text messages one at a time
            while (inputFile.hasNext())
            {
                for (int i = 0; i < MAXROWS; i++)
                    for (int j = 0; j < MAXCOLS; j++)
                        starData[i][j] = inputFile.nextInt();
            }
        }
        catch (IOException e)
        {
            System.out.println("Problem with file - Shutting down.");
            System.exit(0);
        }
    }

    // Scan for stars and write a text-based image marking stars with an asterisk
    // Note:  Stars on outside boundary are ignored in analysis
    // Output is stored in starMarkers array.
    public void ScanForStars() {
        starMarkers = new String[MAXROWS][MAXCOLS];

        for (int i = 1; i < MAXROWS - 1; i++) {
            for (int j = 1; j < MAXCOLS - 1; j++) {
                //same inital for-loops but now we sum for
                double sum = starData[i][j] //center
                        + starData[i-1][j] //up
                        + starData[i+1][j] // down
                        + starData[i][j-1] //left
                        + starData[i][j+1] // right
                        + starData[i-1][j-1]//top-left diagonal
                        + starData[i-1][j+1] // top-right diagonal
                        + starData[i+1][j-1] //bottom-left diagonal
                        + starData[i+1][j+1];//bottom-right diagonal

                double average = sum / 9.0; // divide by 9 (8+1)

                //flag for average that exceeds 5.3
                if (average > 5.3)
                    starMarkers[i][j] = "*"; 
                else
                    starMarkers[i][j] = " ";
            }
        }
    }

    // Write start scan array to one string and return.
    // Pre:  starMarkers 2-D array has been build.
    public String toString()
    {
        String outStarString = "";
        outStarString += "---------------" + "\n";  // Top line
        for (int i = 1; i < MAXROWS-1; i++)
        {
            outStarString +=  "| ";   // Left boundary

            for (int j=1; j<MAXCOLS-1; j++)
            {
                // If average brightness of current star and surrounding 4 is over
                // 5, the define this position as likely star
                outStarString += starMarkers[i][j] + " ";
            }
            outStarString +=  "|" + "\n";   // Right boundary
        }
        outStarString +=  "---------------";  // Bottom line

        return outStarString;
    }
}
