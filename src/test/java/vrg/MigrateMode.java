package vrg;

import org.mybatis.generator.api.ShellRunner;

public class MigrateMode {
	public static void main(String[] args) {
		String[] args2 = { "-configfile", "E:\\code\\vrg\\src\\main\\webapp\\WEB-INF\\lib\\generator.xml",
				"-overwrite" };
		ShellRunner.main(args2);
	}
}
