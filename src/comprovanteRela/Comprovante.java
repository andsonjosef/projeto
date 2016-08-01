package comprovanteRela;
import java.io.InputStream;
import java.util.List;


import br.edu.fasete.principais.Pagamento;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;



public class Comprovante {
	public  void gerarComprovante (List<Pagamento> lista) throws JRException{
		InputStream arq = (InputStream) Comprovante.class.getResourceAsStream("/comprovante/comprovante.jrxml");
		JasperReport report = JasperCompileManager.compileReport(arq);
		JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(lista));
		JasperViewer.viewReport(print,false);
	}
	
	

}
