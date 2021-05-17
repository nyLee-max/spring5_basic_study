package spring5_basic_study;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring5_basic_study.di.ChangePasswordService;
import spring5_basic_study.di.MemberDao;
import spring5_basic_study.di.MemberListPrinter;
import spring5_basic_study.di.MemberPrinter;
import spring5_basic_study.di.MemberRegisterService;

@Configuration
public class AppContext {

	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}
	
	@Bean
	public Greeter greeter() {
		Greeter g = new Greeter();
		g.setFormat("%s, 안녕하세요");
		return g;
	}

	@Bean
	public MemberPrinter memberPrinter() {
		return new MemberPrinter();
	}
	
	@Bean
	public MemberListPrinter memberListPrinter() {
		return new MemberListPrinter(/* memberDao(), memberPrinter() */);
	}
	
	@Bean
	public MemberRegisterService memberRegSvc() {
		return new MemberRegisterService(/* memberDao() */);
	}
	
	@Bean
	public ChangePasswordService changePwdSvc() {
		ChangePasswordService pwdSvc = new ChangePasswordService();
		pwdSvc.setMemberDao(memberDao());
		return pwdSvc;
	}
}
