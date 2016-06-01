package lxy.poi.test;

import java.io.File;

public class MyFileRemove {

	// private static List ALLFILE = new ArrayList();

	public static void main(String[] args) {
		// File f = new File(
		// "E:\\农行报告\\2014\\中国农业银行福建省分行\\中国农业银行福建省分行机关\\350102590511047_吴建华_2014.pdf");
		// getAllFile(new File("D:\\123\\"));
		// for (Iterator it = ALLFILE.iterator(); it.hasNext();) {
		// File ff = (File) it.next();
		// // moveFile(ff);
		// System.out.println(ff.getName());
		// }
		File f = new File("E:\\农行报告\\2014\\2014\\");
		File[] fs = f.listFiles();
		// for (int i = 0; i < fs.length; i++) {
		// final File fsi = fs[i];
		// new Thread() {
		// public void run() {
		try {
			getAllFile(f);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		// }
		// }.start();
		// }
	}

	public static void getAllFile(File f) {
		if (f.isFile()) {
			moveFile(f);
		} else {
			File[] fs = f.listFiles();

			for (int i = 0; i < fs.length; i++) {
				getAllFile(fs[i]);
			}

			boolean succ = f.delete();
			int i = 0;
			while (!succ&&i<3) {
				succ = f.delete();
				i++;
//				if (i > 3) {
					System.out.println("Delete " + f.getPath() + " fall");
//					// System.exit(0);
//				}
			}
		}
	}

	public static void moveFile(File f) {
		String path = f.getPath();
		String newPath = "";
		// 5层
		for (int i = 0; i < 5; i++) {
			newPath += path.substring(0, path.indexOf(File.separator))
					+ File.separator;
			path = path.substring(path.indexOf(File.separator) + 1);
		}
		newPath += f.getName().toUpperCase().replace(".PDF", ".pdf");

		File fnew = new File(newPath);

		if (!f.getPath().equalsIgnoreCase(newPath)) {
			int i = 0;
			while (fnew.exists() && fnew.isFile()) {
				System.out.println("exist:" + newPath);
				newPath = newPath.replace((i == 0 ? "" : "_" + i) + ".pdf", "_"
						+ (++i) + ".pdf");
				System.out.print("rename :" + newPath);
				fnew = new File(newPath);
			}
			boolean succ = f.renameTo(new File(newPath));
			int n = 0;
			while (!succ) {
				succ = f.renameTo(new File(newPath));
				n++;
				if (n > 3) {
					System.out.println("Rename " + f.getPath() + " to "
							+ newPath + " fall");
					System.exit(0);
				}
			}
		}

	}
}
