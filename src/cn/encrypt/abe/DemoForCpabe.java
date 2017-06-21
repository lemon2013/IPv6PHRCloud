package cn.encrypt.abe;


public class DemoForCpabe {
	final static boolean DEBUG = true;
	//file_dir
	static String pubfile = "d://pub_key.txt";
	static String mskfile = "d://master_key.txt";
	static String prvfile = "d://prv_key.txt";

	static String inputfile = "d://input.txt";
	static String encfile = "d://ciphertext.txt";//加密后数据
	static String decfile = "d://plaintext.txt";//解密后数据

	static String[] attr = { "baf1", "fim1", "foo" };//属性集
	static String policy = "foo bar fim 2of3 baf 1of2";//访问策略

	static String student_attr = "部门：呼吸内科 部门：内科 姓名:zhangsan";
			

	static String student_policy = "部门:外科 部门：内科 1of2";

	public static void main(String[] args) throws Exception {
		String attr_str;
		// attr = attr_kevin;
		// attr = attr_sara;
		// policy = policy_kevin_or_sara;
		//attr_str = array2Str(attr);

		attr_str = student_attr;
		policy = student_policy;

		Cpabe test = new Cpabe();
		println("//start to setup");
		test.setup(pubfile, mskfile);
		println("//end to setup");

		println("//start to keygen");
		test.keygen(pubfile, prvfile, mskfile, attr_str);
		println("//end to keygen");

		println("//start to enc");
		test.enc(pubfile, policy, inputfile, encfile);
		println("//end to enc");

		println("//start to dec");
		test.dec(pubfile, prvfile, encfile, decfile);
		println("//end to dec");
	}

	/* connect element of array with blank */
	public static String array2Str(String[] arr) {
		int len = arr.length;
		String str = arr[0];

		for (int i = 1; i < len; i++) {
			str += " ";
			str += arr[i];
		}

		return str;
	}

	private static void println(Object o) {
		if (DEBUG)
			System.out.println(o);
	}
}
