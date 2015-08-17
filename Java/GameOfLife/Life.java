

public class Life
{
	private boolean[][] materialPlane;
	private int xMax;
	private int yMax;

	public static void main(String[] args)
	{
		Life board = new Life(10, 10);

		board.toggleCellState(0, 9);
		board.toggleCellState(1, 1);
		board.toggleCellState(1, 3);
		board.toggleCellState(1, 7);
		board.toggleCellState(3, 2);
		board.toggleCellState(3, 4);
		board.toggleCellState(3, 9);
		board.toggleCellState(4, 1);
		board.toggleCellState(4, 4);
		board.toggleCellState(4, 8);
		board.toggleCellState(5, 9);
		board.toggleCellState(7, 5);
		board.toggleCellState(7, 8);
		board.toggleCellState(8, 1);
		board.toggleCellState(8, 6);
		board.toggleCellState(9, 5);
		board.toggleCellState(9, 6);

		System.out.println(board.printMaterialPlane());

		for(int i = 0; i < 10; i++)
		{
			board.runStep();
			System.out.println(board.printMaterialPlane());
		}
	}
	
	public Life(int xMax, int yMax)
	{
		// Get boundries of the living space
		this.xMax = xMax;
		this.yMax = yMax;

		// Initialize an array to size specified
		materialPlane = new boolean[xMax][yMax];

		// Set all cells to dead
		for(int x = 0; x < xMax; x++)
		{
			for(int y = 0; y < yMax; y++)
			{
				materialPlane[x][y] = false;
			}
		}
	}

	public void toggleCellState(int x, int y)
	{
		if(checkCoordinates(x, y))
		{
			materialPlane[y][x] = !materialPlane[y][x];
		}
	}

	public boolean getCellState(int x, int y)
	{
		if(checkCoordinates(x, y))
		{
			return materialPlane[x][y];
		}

		// Any cell outside the boundries is automatically dead
		// Nothing can survive in the Wasteland
		return false;
	}

	private boolean checkCoordinates(int x, int y)
	{
		return (x >= 0 && x < xMax) && (y >= 0 && y < yMax);
	}

	private boolean getNextCellGeneration(int x, int y)
	{
		// only need to see how many are alive around cell
		int alive = 0;
		// current state of cell we care about;
		boolean currentCell = getCellState(x, y);

		for(int a = -1; a <= 1; a++)
		{
			for(int b = -1; b <= 1; b++)
			{
				if(!(a == 0 && b == 0) && getCellState(x + a,y + b))
				{
					alive++;
				}
			}
		}

		// Actually check for alive/dead state

		// Cell dies
		if(currentCell && (alive < 2 || alive > 3))
		{
			return false;
		}
		// Cell is born
		else if(!currentCell && alive == 3)
		{
			return true;
		}

		// Cell remains what it was
		return currentCell;
	}

	// Run one step into the future
	public void runStep()
	{
		boolean[][] futureMaterialPlane = new boolean[xMax][yMax];
		
		for(int x = 0; x < xMax; x++)
		{
			for(int y = 0; y < yMax; y++)
			{
				futureMaterialPlane[x][y] = getNextCellGeneration(x, y);
			}
		}

		// Transfer new plane to the present
		materialPlane = futureMaterialPlane;
	}

	public void runSteps(int steps)
	{
		for(int i = 0; i < steps; i++)
		{
			runStep();
		}
	}

	public String printMaterialPlane()
	{
		StringBuilder materialPlaneString = new StringBuilder();

		for(int y = 0; y < yMax; y++)
		{
			for(int x = 0; x < xMax; x++)
			{
				if(getCellState(x, y))
				{
					materialPlaneString.append("X");
				}
				else
				{
					materialPlaneString.append(".");
				}
			}

			materialPlaneString.append("\n");
		}

		return materialPlaneString.toString();
	}
}