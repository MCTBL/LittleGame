package cuberTimer;

public class Cube {

	int status[][];
	int unengage[] = { 5, 3, 4, 1, 2, 0 };

	public Cube() {
		status = new int[6][9];
		// 3:°× 6:³È 1:ÂÌ 5:ºì 2:À¶ 4:»Æ
		int color[] = { 3, 6, 1, 5, 2, 4 };
		for (int x = 0; x < 6; x++) {
			for (int i = 0; i < 9; i++) {
				status[x][i] = color[x];
			}
		}
	}
	
	public Cube(int status[][]) {
		this.status = status;
	}

	public Cube(String setUp) {
		status = new int[6][9];
		// 3:°× 6:³È 1:ÂÌ 5:ºì 2:À¶ 4:»Æ
		int color[] = { 3, 6, 1, 5, 2, 4 };
		for (int x = 0; x < 6; x++) {
			for (int i = 0; i < 9; i++) {
				status[x][i] = color[x];
			}
		}
		String temp[] = setUp.split(" ");
		for (String i : temp) {
			switch (i) {
			case "U":
				this.U();
				break;
			case "U'":
				this.dU();
				break;
			case "U2":
				this.U();
				this.U();
				break;
			case "D":
				this.D();
				break;
			case "D'":
				this.dD();
				break;
			case "D2":
				this.D();
				this.D();
				break;
			case "R":
				this.R();
				break;
			case "R'":
				this.dR();
				break;
			case "R2":
				this.R();
				this.R();
				break;
			case "L":
				this.L();
				break;
			case "L'":
				this.dL();
				break;
			case "L2":
				this.L();
				this.L();
				break;
			case "F":
				this.F();
				break;
			case "F'":
				this.dF();
				break;
			case "F2":
				this.F();
				this.F();
				break;
			case "B":
				this.B();
				break;
			case "B'":
				this.dB();
				break;
			case "B2":
				this.B();
				this.B();
				break;
			}
		}
	}

	public void declocksWise(int face[]) {
		// TODO Auto-generated method stub
		int temp1 = face[0];
		int temp2 = face[1];
		face[1] = face[5];
		face[5] = face[7];
		face[7] = face[3];
		face[3] = temp2;

		face[0] = face[2];
		face[2] = face[8];
		face[8] = face[6];
		face[6] = temp1;
	}

	public void clocksWise(int face[]) {
		// TODO Auto-generated method stub
		int temp1 = face[0];
		int temp2 = face[1];
		face[1] = face[3];
		face[3] = face[7];
		face[7] = face[5];
		face[5] = temp2;

		face[0] = face[6];
		face[6] = face[8];
		face[8] = face[2];
		face[2] = temp1;
	}

	public void U() {
		clocksWise(status[0]);
		int temp0 = status[1][0];
		int temp1 = status[1][1];
		int temp2 = status[1][2];
		for (int i = 0; i < 3; i++) {
			status[i + 1][0] = status[i + 2][0];
			status[i + 1][1] = status[i + 2][1];
			status[i + 1][2] = status[i + 2][2];
		}
		status[4][0] = temp0;
		status[4][1] = temp1;
		status[4][2] = temp2;
	}

	public void dU() {
		declocksWise(status[0]);
		int temp0 = status[4][0];
		int temp1 = status[4][1];
		int temp2 = status[4][2];
		for (int i = 4; i > 1; i--) {
			status[i][0] = status[i - 1][0];
			status[i][1] = status[i - 1][1];
			status[i][2] = status[i - 1][2];
		}
		status[1][0] = temp0;
		status[1][1] = temp1;
		status[1][2] = temp2;
	}

	public void D() {
		clocksWise(status[5]);
		int temp0 = status[4][6];
		int temp1 = status[4][7];
		int temp2 = status[4][8];
		for (int i = 4; i > 1; i--) {
			status[i][6] = status[i - 1][6];
			status[i][7] = status[i - 1][7];
			status[i][8] = status[i - 1][8];
		}
		status[1][6] = temp0;
		status[1][7] = temp1;
		status[1][8] = temp2;
	}

	public void dD() {
		declocksWise(status[5]);
		int temp0 = status[1][6];
		int temp1 = status[1][7];
		int temp2 = status[1][8];
		for (int i = 0; i < 3; i++) {
			status[i + 1][6] = status[i + 2][6];
			status[i + 1][7] = status[i + 2][7];
			status[i + 1][8] = status[i + 2][8];
		}
		status[4][6] = temp0;
		status[4][7] = temp1;
		status[4][8] = temp2;
	}

	public void F() {
		clocksWise(status[2]);
		int temp0 = status[0][6];
		int temp1 = status[0][7];
		int temp2 = status[0][8];

		status[0][6] = status[1][8];
		status[0][7] = status[1][5];
		status[0][8] = status[1][2];

		status[1][8] = status[5][2];
		status[1][5] = status[5][1];
		status[1][2] = status[5][0];

		status[5][2] = status[3][0];
		status[5][1] = status[3][3];
		status[5][0] = status[3][6];

		status[3][0] = temp0;
		status[3][3] = temp1;
		status[3][6] = temp2;
	}

	public void dF() {
		declocksWise(status[2]);
		int temp0 = status[0][6];
		int temp1 = status[0][7];
		int temp2 = status[0][8];

		status[0][6] = status[3][0];
		status[0][7] = status[3][3];
		status[0][8] = status[3][6];

		status[3][0] = status[5][2];
		status[3][3] = status[5][1];
		status[3][6] = status[5][0];

		status[5][2] = status[1][8];
		status[5][1] = status[1][5];
		status[5][0] = status[1][2];

		status[1][8] = temp0;
		status[1][5] = temp1;
		status[1][2] = temp2;
	}

	public void B() {
		clocksWise(status[4]);
		int temp0 = status[0][0];
		int temp1 = status[0][1];
		int temp2 = status[0][2];

		status[0][0] = status[3][2];
		status[0][1] = status[3][5];
		status[0][2] = status[3][8];

		status[3][2] = status[5][8];
		status[3][5] = status[5][7];
		status[3][8] = status[5][6];

		status[5][8] = status[1][6];
		status[5][7] = status[1][3];
		status[5][6] = status[1][0];

		status[1][6] = temp0;
		status[1][3] = temp1;
		status[1][0] = temp2;
	}

	public void dB() {
		declocksWise(status[4]);
		int temp0 = status[0][0];
		int temp1 = status[0][1];
		int temp2 = status[0][2];

		status[0][0] = status[1][6];
		status[0][1] = status[1][3];
		status[0][2] = status[1][0];

		status[1][6] = status[5][8];
		status[1][3] = status[5][7];
		status[1][0] = status[5][6];

		status[5][8] = status[3][2];
		status[5][7] = status[3][5];
		status[5][6] = status[3][8];

		status[3][2] = temp0;
		status[3][5] = temp1;
		status[3][8] = temp2;
	}

	public void R() {
		clocksWise(status[3]);
		int temp0 = status[2][2];
		int temp1 = status[2][5];
		int temp2 = status[2][8];

		status[2][2] = status[5][2];
		status[2][5] = status[5][5];
		status[2][8] = status[5][8];

		status[5][2] = status[4][6];
		status[5][5] = status[4][3];
		status[5][8] = status[4][0];

		status[4][6] = status[0][2];
		status[4][3] = status[0][5];
		status[4][0] = status[0][8];

		status[0][2] = temp0;
		status[0][5] = temp1;
		status[0][8] = temp2;
	}

	public void dR() {
		declocksWise(status[3]);
		int temp0 = status[2][2];
		int temp1 = status[2][5];
		int temp2 = status[2][8];

		status[2][2] = status[0][2];
		status[2][5] = status[0][5];
		status[2][8] = status[0][8];

		status[0][2] = status[4][6];
		status[0][5] = status[4][3];
		status[0][8] = status[4][0];

		status[4][6] = status[5][2];
		status[4][3] = status[5][5];
		status[4][0] = status[5][8];

		status[5][2] = temp0;
		status[5][5] = temp1;
		status[5][8] = temp2;
	}

	public void L() {
		clocksWise(status[1]);
		int temp0 = status[2][0];
		int temp1 = status[2][3];
		int temp2 = status[2][6];

		status[2][0] = status[0][0];
		status[2][3] = status[0][3];
		status[2][6] = status[0][6];

		status[0][0] = status[4][8];
		status[0][3] = status[4][5];
		status[0][6] = status[4][2];

		status[4][8] = status[5][0];
		status[4][5] = status[5][3];
		status[4][2] = status[5][6];

		status[5][0] = temp0;
		status[5][3] = temp1;
		status[5][6] = temp2;
	}

	public void dL() {
		declocksWise(status[1]);
		int temp0 = status[2][0];
		int temp1 = status[2][3];
		int temp2 = status[2][6];

		status[2][0] = status[5][0];
		status[2][3] = status[5][3];
		status[2][6] = status[5][6];

		status[5][0] = status[4][8];
		status[5][3] = status[4][5];
		status[5][6] = status[4][2];

		status[4][8] = status[0][0];
		status[4][5] = status[0][3];
		status[4][2] = status[0][6];

		status[0][0] = temp0;
		status[0][3] = temp1;
		status[0][6] = temp2;
	}
}
