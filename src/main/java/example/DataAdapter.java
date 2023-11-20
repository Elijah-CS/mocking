package example;

interface DataAdapter {
  abstract String buildThing(DBService service) throws Exception;
}