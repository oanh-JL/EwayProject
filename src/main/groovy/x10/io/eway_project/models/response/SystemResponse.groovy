package x10.io.eway_project.models.response


class SystemResponse {
    int code
    String title
    String message
    static Map<String, SystemResponse> systemResponseMap
    SystemResponse() {
    }

    SystemResponse(int code, String title, String message) {
        this.code = code
        this.title = title
        this.message = message
    }

    static {
        systemResponseMap = new HashMap<>()
        systemResponseMap.put("inserted", new SystemResponse(200, "inserted!", "inserting was done"))
        systemResponseMap.put("updated", new SystemResponse(200, "updated!", "updating was done"))
        systemResponseMap.put("deleted", new SystemResponse(200, "deleted!", "deleting was done"))
        systemResponseMap.put("required", new SystemResponse(500, "error!", "some fields were required"))
        systemResponseMap.put("duplicate", new SystemResponse(500, "duplicate!", "the fields was existed"))
        systemResponseMap.put("notfound", new SystemResponse(404, "NotFound!", "not found"))
        systemResponseMap.put("required", new SystemResponse(500, "required!", "some fields were missed"))
        systemResponseMap.put("error", new SystemResponse(500, "error!", "executed false"))

    }
}
