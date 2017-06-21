package cn.encrypt.bswabe;

import java.util.ArrayList;
import java.util.List;


import it.unisa.dia.gas.jpbc.Element;
import it.unisa.dia.gas.jpbc.Pairing;
import it.unisa.dia.gas.jpbc.Vector;
import it.unisa.dia.gas.plaf.jpbc.field.vector.VectorElement;
import it.unisa.dia.gas.plaf.jpbc.pairing.PairingFactory;



public class PEUtils {
private static Pairing pairing;
static{
	pairing=PairingFactory.getPairing("a.properties");
}
	
 public static  Element hashToGT(Pairing pairing,String message){
		byte[] byte_message=message.getBytes();
		Element hash=pairing.getGT().newRandomElement().setFromHash(byte_message,0 ,byte_message.length ).getImmutable();
		return hash;
		}
 public static  Element hashToG1(Pairing pairing,String message){
		byte[] byte_message=message.getBytes();
		Element hash=pairing.getG1().newRandomElement().setFromHash(byte_message,0 ,byte_message.length ).getImmutable();
		return hash;
		}
 public static  Element hashToG1(Pairing pairing,byte[] byte_message){
		
		Element hash=pairing.getG1().newRandomElement().setFromHash(byte_message,0 ,byte_message.length ).getImmutable();
		return hash;
		}
 public static Element hashToZr(Pairing pairing,String message){
		byte[] byte_message=message.getBytes();
		Element hash=pairing.getZr().newRandomElement().setFromHash(byte_message,0 ,byte_message.length ).getImmutable();
		return hash;
		}
 public static byte[] hash2(Element e,int n){
		byte b[]=new byte[n];
		b=e.toBytes();
		return b;		
	}

 
}
