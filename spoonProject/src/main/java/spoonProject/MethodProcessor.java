package spoonProject;

import java.util.List;

import org.slf4j.MDC;

import com.example.tp3.Tp3Application;

import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtCodeSnippetStatement;
import spoon.reflect.code.CtComment;
import spoon.reflect.declaration.CtExecutable;
import spoon.reflect.declaration.CtParameter;
import spoon.support.reflect.declaration.CtConstructorImpl;

public class MethodProcessor extends AbstractProcessor<CtExecutable>{
	
	

	@Override
	public boolean isToBeProcessed(CtExecutable candidate) {
		if (candidate.getClass().getSimpleName().equals(CtConstructorImpl.class.getSimpleName()) || !isNotToStringMethod(candidate)) {
			return false;
		}
		return true;

	}

	public void process(CtExecutable element) {
		if (isToBeProcessed(element)) {
			CtCodeSnippetStatement snippet = getFactory().Core().createCodeSnippetStatement();
			StringBuilder sb1 = new StringBuilder();
			StringBuilder sb2 = new StringBuilder();
			List parameters = element.getParameters();
			sb1.append("MDC.put(\"userID\", Tp3Application.getCurrentUser().getID());\n");
			sb1.append("MDC.put(\"userInfo\", Tp3Application.getCurrentUser().toString());\n");
			sb1.append("MDC.put(\"Operation\",\"" + element.getSimpleName()+ ");\n\"");
			List<CtComment>comments = element.getComments();
			System.out.println(comments);
			System.out.println(element.getSimpleName());
			//sb1.append("MDC.put(\"OperationType\"," + comments.get(0).getContent() + ");\n");
			
			if (parameters.size() == 0) {
				sb1.append("\"MDC.put(\"parameters\", \"no parameters given\");\n");
			}else {
				for (int i = 0; i < parameters.size(); i++) {
					CtParameter parameter = (CtParameter) parameters.get(i);
					sb1.append("MDC.put(\"parameters\","+""+ parameter.getSimpleName() + ".toString()");
					if (i < (parameters.size() - 1)) {
						sb1.append("+ \",");
					}
			}
				sb1.append(");\n");

			}
			
			sb2.append("the event of "+ element.getSimpleName());
			final String message  = String.format("%slogger.info(\"%s\")", sb1.toString(), sb2.toString());
			snippet.setValue(message);
			if (element.getBody() != null) {
				element.getBody().insertBegin(snippet);
			}

		}
	}
	
	private boolean isNotToStringMethod(CtExecutable element) {
		if (element.getSimpleName().equals("toString") || element.getSimpleName().equals("getID") 
				|| element.getSimpleName().equals("setID") 
				|| element.getSimpleName().equals("getProducts")
				|| element.getSimpleName().equals("setProducts")
				|| element.getClass().getSimpleName().equals("Product")
				|| element.getClass().getSimpleName().equals("User")
				|| element.getClass().getSimpleName().equals("CustomLogbackJsonLayout")
				|| element.getClass().getSimpleName().equals("Tp3Application")) {
			return false;
		}
		return true;
	}


}
