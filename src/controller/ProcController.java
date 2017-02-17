package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;
import java.util.Set;

public class ProcController {

	public ProcController(){
		super();
	}

	public void propriedades(){
		Properties pr = System.getProperties();
		Set<Object> keys = pr.keySet();
		for (Object k : keys){
			System.out.print(k.toString());
			System.out.print(":");
			System.out.println(pr.getProperty(k.toString()));
		}
	}
	
	public String so(){
		String so = System.getProperty("os.name");
		return so;
	}
	
	public void chamaProcesso(String caminho){
		try {
			Runtime.getRuntime().exec(caminho);
		} catch (IOException e) {
			if (e.getMessage().contains("eleva")){
				StringBuffer sb = new StringBuffer();
				sb.append("cmd /c ");
				sb.append(caminho);
				try {
					Runtime.getRuntime().exec(sb.toString());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			} else {
				e.printStackTrace();
			}
		}
	}
	
	public void leProcesso(String caminho){
		try {
			Process p = Runtime.getRuntime().exec(caminho);
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while (linha != null){
				System.out.println(linha);
				linha = buffer.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void mataProcesso(String processo){
		String cmdPid = "TASKKILL /PID ";
		String cmdNome = "TASKKILL /IM ";
		int pid = 0;
		StringBuffer buffer = new StringBuffer();
		try {
			pid = Integer.parseInt(processo);
			buffer.append(cmdPid);
			buffer.append(pid);
		} catch (NumberFormatException e){
			buffer.append(cmdNome);
			buffer.append(processo);
		}
		try {
			Runtime.getRuntime().exec(buffer.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
}
