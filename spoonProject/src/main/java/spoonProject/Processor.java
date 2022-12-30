package spoonProject;

import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtCodeSnippetExpression;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtField;
import spoon.reflect.declaration.ModifierKind;
import spoon.reflect.reference.CtTypeReference;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.slf4j.MDC;


public class Processor extends AbstractProcessor<CtClass>{
	
	



	public void process(CtClass element) {
		
		final CtTypeReference<Logger> logger = getFactory().Code().createCtTypeReference(Logger.class);
		final CtField<Logger> loggerField = getFactory().Core().<Logger>createField();
		loggerField.<CtField>setType(logger);
		loggerField.<CtField>addModifier(ModifierKind.STATIC);
		loggerField.<CtField>addModifier(ModifierKind.PRIVATE);
		loggerField.setSimpleName("logger");
		
		String expression = "LoggerFactory.getLogger(" + element.getSimpleName() + ".class.getName())";
		final CtCodeSnippetExpression loggerExpression = getFactory().Code().createCodeSnippetExpression(expression);
		loggerField.setDefaultExpression(loggerExpression);
		
		element.addFieldAtTop(loggerField);

	}

}
