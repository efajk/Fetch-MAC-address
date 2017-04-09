package sample;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class fetchMAC {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] MAC = new String[10];
		try{
			Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            NetworkInterface network;
            int flag = 0;
            int numMAC = 0;
            while(interfaces.hasMoreElements()){
                    network = interfaces.nextElement();
                    byte[] mac = network.getHardwareAddress();
                    if(mac != null){
                            StringBuilder sb = new StringBuilder();
                            for (int i = 0; i < mac.length; i++) {
                                    sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
                            }
                            System.out.print("Current MAC address : ");
                            System.out.print(sb.toString() + "\n");
                            MAC[numMAC] = sb.toString();
                            numMAC++;
                    }
            }
		
		}catch(SocketException e){
            e.printStackTrace();
		}
		String tmp = "2.16.886.111.100003";
        int idxMAC = 0;
        for (String y : MAC){
                if(y != null){
                        tmp+=".";
                        String[] cArr = y.split("-");
                        int idx = 0;
                        for (String d : cArr){
                                int x =Integer.parseInt(d,16);
                                String s = Integer.toString(x);
                                tmp+=s;
                                if(idx != 5)
                                        tmp+=".";
                                idx++;
                        }
                        System.out.print(tmp + "\n");
                        idxMAC++;
                }
        }

        System.out.print(tmp);
	}

}

