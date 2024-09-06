import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class questao3 {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse("src/faturamento.xml");

            document.getDocumentElement().normalize();

            NodeList rows = document.getElementsByTagName("row");

            double menorValor = Double.MAX_VALUE;
            double maiorValor = Double.MIN_VALUE;
            double soma = 0.0;
            int diasComFaturamentoAcimaDaMedia = 0;

            int count = 0;

            for (int i = 0; i < rows.getLength(); i++) {
                Element row = (Element) rows.item(i);
                double valor = Double.parseDouble(row.getElementsByTagName("valor").item(0).getTextContent());

                // atualiza o menor e maior valor
                if (valor > 0) {
                    if (valor < menorValor) {
                        menorValor = valor;
                    }
                    if (valor > maiorValor) {
                        maiorValor = valor;
                    }
                }

                soma += valor;
                count++;
            }

            double media = soma / count;

            // Recalcula os dias com faturamento acima da média
            for (int i = 0; i < rows.getLength(); i++) {
                Element row = (Element) rows.item(i);
                double valor = Double.parseDouble(row.getElementsByTagName("valor").item(0).getTextContent());

                if (valor > media) {
                    diasComFaturamentoAcimaDaMedia++;
                }
            }

            System.out.println("Menor valor de faturamento: " + menorValor);
            System.out.println("Maior valor de faturamento: " + maiorValor);
            System.out.println("Número de dias com faturamento acima da média: " + diasComFaturamentoAcimaDaMedia);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}