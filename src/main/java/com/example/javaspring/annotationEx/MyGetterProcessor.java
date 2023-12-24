package com.example.javaspring.annotationEx;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;
import java.util.Set;

public class MyGetterProcessor extends AbstractProcessor {

    @Override
    public synchronized void init(ProcessingEnvironment env){ }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
    return true;
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {return null; }

    @Override
    public SourceVersion getSupportedSourceVersion() { return null;}

}
