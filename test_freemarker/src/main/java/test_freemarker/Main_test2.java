package test_freemarker;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import fr.opensagres.xdocreport.converter.ConverterRegistry;
import fr.opensagres.xdocreport.converter.ConverterTypeTo;
import fr.opensagres.xdocreport.converter.ConverterTypeVia;
import fr.opensagres.xdocreport.converter.IConverter;
import fr.opensagres.xdocreport.converter.Options;
import fr.opensagres.xdocreport.core.XDocReportException;
import fr.opensagres.xdocreport.core.document.DocumentKind;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.images.ClassPathImageProvider;
import fr.opensagres.xdocreport.document.images.IImageProvider;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;
import fr.opensagres.xdocreport.template.annotations.FieldMetadata;
import fr.opensagres.xdocreport.template.formatter.FieldsMetadata;
import fr.opensagres.xdocreport.template.annotations.ImageMetadata;

public class Main_test2 {
	
	@FieldMetadata( images = { @ImageMetadata( name = "image_1" ) } )
    public static File  getLogo()
    {
        return new File("/home/autor/capture.png" );
    }

	public static void main(String[] args) {
		

		try {
		      // 1) Load Docx file by filling Velocity template engine and cache it to the registry
		      InputStream in = new FileInputStream(new File("/home/autor/Desktop/freemarker/test5.odt"));
		      IXDocReport report = XDocReportRegistry.getRegistry().loadReport(in,TemplateEngineKind.Freemarker);

		      
		      FieldsMetadata metadata = report.createFieldsMetadata();
		      metadata.addFieldAsImage( "image_1", "image_1");
		      report.setFieldsMetadata(metadata);

		      IContext context = report.createContext();
		      
		      context.put("titre", "un titre");
		      context.put("texte1", "un texte\n\tkjhlkn\njjklkgjlgkl");
		      context.put("pied", "un pied");

		      context.put("image_1", getLogo());

		      // 3) Generate report by merging Java model with the Docx
		      OutputStream out = new FileOutputStream(new File("/home/autor/Desktop/freemarker/test10_out.odt"));
		      report.process(context, out);

              OutputStream out2 = new FileOutputStream(new File("/home/autor/Desktop/freemarker/test10_out.pdf"));
              // 1) Create options ODT 2 PDF to select well converter form the registry
              Options options = Options.getFrom(DocumentKind.ODT).to(ConverterTypeTo.PDF);

              // 2) Get the converter from the registry
              IConverter converter = ConverterRegistry.getRegistry().getConverter(options);
   
              report.convert(context, options, out2);

		    } catch (IOException e) {
		      e.printStackTrace();
		    } catch (XDocReportException e) {
		      e.printStackTrace();
		    }

	}

}
