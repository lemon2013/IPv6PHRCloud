package cn.encrypt.bswabe;

import java.util.ArrayList;

import it.unisa.dia.gas.jpbc.Element;

public class BswabePrv {
	/*
	 * A private key
	 */
	public Element d; /* G_2 */
	public ArrayList<BswabePrvComp> comps; /* BswabePrvComp */
}