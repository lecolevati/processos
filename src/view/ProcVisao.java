package view;

import controller.ProcController;

public class ProcVisao {

	public static void main(String[] args) {
		ProcController pc = new ProcController();
		pc.propriedades();
		// System.out.println(pc.so());
		// pc.chamaProcesso("regedit.exe");
		// pc.leProcesso("ping -t10 www.fateczl.edu.br");
		// pc.mataProcesso("cmd.exe");
	}
}
