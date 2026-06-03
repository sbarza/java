public interface Mappable {

    String JSON_PROPERTY = """
            "properties": {%s} """;

    // This method returns a label (how the item will be described on the map)
    String getLabel();

    // This method returns a geometry type (POINT or LINE) which is what the type will look like on the map
    Geometry getShape();

    // This method returns an icon type (sometimes called a map marker)
    String getMarker();

    static void mapIt(Mappable mappable) {
        System.out.println(JSON_PROPERTY.formatted(mappable.toJSON()));
    }

    default String toJSON() {
        String properties = """
                "type": "%s", "label": "%s", "marker": "%s" """;

        return properties.formatted(getShape(), getLabel(), getMarker());
    }
}
