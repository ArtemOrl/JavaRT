package com.javarush.task.task33.task3309;

import org.w3c.dom.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
//    package com.javarush.task.task33.task3309;
//
////import org.w3c.dom.Comment;
////import org.w3c.dom.Document;
////import org.w3c.dom.Node;
////import org.w3c.dom.NodeList;
////import org.xml.sax.InputSource;
////import org.xml.sax.SAXException;
////
////import javax.xml.bind.JAXBContext;
////import javax.xml.bind.JAXBException;
////import javax.xml.bind.Marshaller;
////import javax.xml.parsers.DocumentBuilder;
////import javax.xml.parsers.DocumentBuilderFactory;
////import javax.xml.parsers.ParserConfigurationException;
////import javax.xml.stream.XMLStreamWriter;
////import javax.xml.transform.OutputKeys;
////import javax.xml.transform.Transformer;
////import javax.xml.transform.TransformerException;
////import javax.xml.transform.TransformerFactory;
////import javax.xml.transform.dom.DOMSource;
////import javax.xml.transform.stream.StreamResult;
////import java.io.IOException;
////import java.io.StringReader;
////import java.io.StringWriter;
////import java.util.regex.Matcher;
////import java.util.regex.Pattern;
//
//import org.w3c.dom.*;
//
//import javax.xml.bind.JAXBContext;
//import javax.xml.bind.JAXBException;
//import javax.xml.bind.Marshaller;
//import javax.xml.parsers.DocumentBuilder;
//import javax.xml.parsers.DocumentBuilderFactory;
//import javax.xml.parsers.ParserConfigurationException;
//import javax.xml.transform.OutputKeys;
//import javax.xml.transform.Transformer;
//import javax.xml.transform.TransformerFactory;
//import javax.xml.transform.dom.DOMSource;
//import javax.xml.transform.stream.StreamResult;
//import java.io.StringWriter;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//    /*
//    Комментарий внутри xml
//    */
//    public class Solution {
////    public static String toXmlWithComment(Object obj, String tagName, String comment) {
////
//////        StringWriter writer = new StringWriter();
//////        String res = null;
//////        try {
//////            JAXBContext context = JAXBContext.newInstance(obj.getClass());
//////            Marshaller marshaller = context.createMarshaller();
//////            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
//////            marshaller.marshal(obj, writer);
//////
//////            String xml = writer.toString();
//////
//////            if (xml.indexOf(tagName) > -1)
//////                res = xml.replace("<" + tagName + ">", "<!--" + comment + "-->\n" + "<" + tagName + ">");
//////            else
//////                res = xml;
//////
//////        } catch (JAXBException e) {
//////            e.printStackTrace();
//////        }
//////        return res;
////
////        try {
////
////            JAXBContext context = JAXBContext.newInstance(obj.getClass());
////            Marshaller marshaller = context.createMarshaller();
////            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
////            Document doc = (Document) DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
////            marshaller.marshal(obj, (XMLStreamWriter) doc);
////
////            NodeList nodes = doc.getElementsByTagName("*");
////
////            for (int i = 0; i < nodes.getLength(); i++) {
////                Node node = nodes.item(i);
////
////                if (node.getNodeName().equals(tagName)) {
////                    Comment com = doc.createComment(comment);
////                    node.getParentNode().insertBefore(com, node);
////                }
////                replaceTextWithCDATA(node, doc);
////            }
////            Transformer transformer = TransformerFactory.newInstance().newTransformer();
////            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
////            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
////
////            StringWriter sw = new StringWriter();
////            transformer.transform(new DOMSource(doc), new StreamResult(sw));
////            return sw.toString();
////
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
////        return null;
////    }
////
////    private static void replaceTextWithCDATA(Node node, Document doc) {
////        if ((node.getNodeType() == 3) && (Pattern.compile("[<>&'\"]").matcher(node.getTextContent()).find())) {
////
////            Node cnode = doc.createCDATASection(node.getNodeValue());
////            node.getParentNode().replaceChild(cnode, node);
////        }
////
////        NodeList list = node.getChildNodes();
////
////        for (int i = 0; i < list.getLength(); i++) {
////            replaceTextWithCDATA(list.item(i), doc);
////        }
////    }
////    public static void main(String[] args) {
////
//////        String s = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><first><second>some string</second><second>some string</second><second><![CDATA[need CDATA because of < and >]]></second><second/></first>";
//////
//////        String comment = "it's a comment";
//////        String tagName = "second";
//////
//////        String res = null;
//////        if (s.indexOf(tagName) > -1)
//////            res = s.replace("<" + tagName + ">", "<!--" + comment + "-->" + "<" + tagName + ">");
//////
//////        System.out.println(res);
////    }
//
//
//
//
//        //iter2
////public static String toXmlWithComment(Object obj, String tagName, String comment) throws TransformerException, IOException, SAXException, JAXBException, ParserConfigurationException {
//////    //сериализуем объект в XML
//////    StringWriter writer = new StringWriter();
//////    JAXBContext context = JAXBContext.newInstance(obj.getClass());
//////    Marshaller marshaller = context.createMarshaller();
//////    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
//////    marshaller.marshal(obj, writer);
//////    String xml = writer.toString();
//////    //сериализация
//////
//////    DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
//////    DocumentBuilder builder = docBuilderFactory.newDocumentBuilder();
//////    Document doc = builder.parse(new InputSource(new StringReader(xml)));//представление XML в виде множества узлов
//////    //альтернативный вариант: сразу сериализовать объект в doc
//////    //Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
//////    //marshaller.marshal(obj, doc);
//////
//////    NodeList nodes = doc.getElementsByTagName("*"); //это коллекция, которая содержит все ЭЛЕМЕНТЫ представления XML
//////    //метод Document.getElementsByTagName() позволяет проходить XML не построчно, а по ЭЛЕМЕНТАМ
//////
//////    for (int i = 0; i < nodes.getLength(); i++) {
//////        Node node = nodes.item(i);
//////
//////        if (node.getNodeName().equals(tagName)) {
//////            Comment com = doc.createComment(comment); //+ System.getProperty("line.separator")
//////            node.getParentNode().insertBefore(com, node);
//////        }
//////        replaceTextWithCDATA(node, doc);
//////    }
//////    Transformer transformer = TransformerFactory.newInstance().newTransformer();
//////    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
//////    //transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
//////
//////    writer = new StringWriter();
//////    transformer.transform(new DOMSource(doc), new StreamResult(writer));
//////    return writer.toString();
//////}
//////
//////    private static void replaceTextWithCDATA(Node node, Document doc) {
//////        //".*[<>&'\"].*"
//////        //"[<>&'\"]"
//////        if ((node.getNodeType() == 3) && (Pattern.compile(".*[<>&'\"].*").matcher(node.getTextContent()).find())) {
//////            Node cnode = doc.createCDATASection(node.getNodeValue());
//////            node.getParentNode().replaceChild(cnode, node);
//////        }
//////
//////        NodeList list = node.getChildNodes();
//////
//////        for (int i = 0; i < list.getLength(); i++) {
//////            replaceTextWithCDATA(list.item(i), doc);
//////        }
//////    }
//////
//////    public static void main(String[] args) throws Exception {
////////        SomeObject someObject = new SomeObject();
////////        someObject.name = "daedra";
////////        System.out.println(toXmlWithComment(someObject, "name", "it's a comment"));
//////    }
//
//        public static String toXmlWithComment(Object obj, String tagName, String comment) {
//
//            // Создаю документ DOM из объекта в аргументе:
//            Document document = null;
//            try {
//                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//                DocumentBuilder db = dbf.newDocumentBuilder();
//                document = db.newDocument();
//
//                JAXBContext context = JAXBContext.newInstance(obj.getClass());
//                Marshaller marshaller = context.createMarshaller();
//                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
//                marshaller.marshal(obj, document);
//                document.getDocumentElement().normalize();
//
//            } catch (ParserConfigurationException e) {
//                e.printStackTrace();
//            } catch (JAXBException e) {
//                e.printStackTrace();
//            }
//
//            // достаю root узел
//            Node root = document.getDocumentElement();
//
//            NodeList nodeList = ((Element) root).getElementsByTagName(tagName);
//            for (int i = 0; i < nodeList.getLength(); i++) {
//                Node n = nodeList.item(i);
//                n.getParentNode().insertBefore(document.createComment(comment), n);
//            }
//
//            addCDATA(document, root);
//
//
//            // еще один метод для конвертации измененного документа DOM в строку
//            String result = null;
//            try {
//                result = convertDOMtoXML(document);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//            return result;
//
//        }
//
//        public static void addCDATA(Document doc, Node startNode) {
//
//            for (Node node = startNode.getFirstChild(); node != null;) {
//                Node nextNode = node.getNextSibling();
//
//                if (node.getNodeValue() == null) {
//
//                    if (hasCDATA(node.getTextContent())) {
//
//                        String stringToConvert = node.getTextContent();
//
//                        CDATASection cdata = doc.createCDATASection(stringToConvert);
//                        node.setTextContent("");
//                        node.appendChild(cdata);
//
//                    }
//                }
//
//                if (node.hasChildNodes()) {
//                    addCDATA(doc, node);
//                }
//
//                node = nextNode;
//            }
//        }
//
//
//        // Вспомогательный метод для проверки наличия запрещенных символов " ' < > &
//        public static boolean hasCDATA(String check) {
//
//            Pattern p = Pattern.compile("[\"\'<>&]");
//            Matcher m = p.matcher(check);
//            if (m.find()) {
//                return true;
//            }
//            return false;
//        }
//
//
//        // Вспомогательный метод для конвертации документа в строку:
//        public static String convertDOMtoXML(Document DOMDocument) throws Exception {
//
//            TransformerFactory tFactory = TransformerFactory.newInstance();
//            Transformer transformer = tFactory.newTransformer();
//            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
//
//            StringWriter writer = new StringWriter();
//            StreamResult result = new StreamResult(writer);
//            DOMSource source = new DOMSource(DOMDocument);
//            transformer.transform(source, result);
//            return writer.toString();
//        }
//
//
//
//        public static void main(String[] args) {
////        // Проверочный код
////        Dog dog = new Dog();
////        dog.age = 5;
////        dog.dogName = "Sharik";
////        dog.owner = "Arnold";
////        dog.owner2 = "Kuzma";
////        dog.needCDATA = "need CDATA cause of > ---";
////        String x = toXmlWithComment(dog, "dogOwnerXML", "comment Ha-ha-ha-ha!");
////        System.out.println(x);
//        }
//    }

}
