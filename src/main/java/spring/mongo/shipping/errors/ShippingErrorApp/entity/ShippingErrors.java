package spring.mongo.shipping.errors.ShippingErrorApp.entity;


import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;
import org.springframework.data.mongodb.repository.Meta;

import java.util.Date;

@Document(collection = "shipping_errors")
public class ShippingErrors {
    @MongoId
    private String _id;
    private String order;
    private String lpn;
    private Date date_time;
    private String message;
    private int error_code;
    private String location;
    private int device_id;
    private String type;
    private boolean open_order_status;
    private Metadata metadata;
    private Date closed_date;

    public ShippingErrors(String _id, String order, String lpn, Date date_time, String message, int error_code,
                          String location, int device_id, String type, boolean open_order_status, Metadata metadata, Date closed_date) {
        this._id = _id;
        this.order = order;
        this.lpn = lpn;
        this.date_time = date_time;
        this.message = message;
        this.error_code = error_code;
        this.location = location;
        this.device_id = device_id;
        this.type = type;
        this.open_order_status = open_order_status;
        this.metadata = metadata;
        this.closed_date = closed_date;
    }

    public ShippingErrors() {
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public Date getDate_time() {
        return date_time;
    }

    public void setDate_time(Date date_time) {
        this.date_time = date_time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    public Date getClosed_date() {
        return closed_date;
    }

    public void setClosed_date(Date closed_date) {
        this.closed_date = closed_date;
    }

    public String getLpn() {
        return lpn;
    }

    public void setLpn(String lpn) {
        this.lpn = lpn;
    }

    public int getDevice_id() {
        return device_id;
    }

    public void setDevice_id(int device_id) {
        this.device_id = device_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isOpen_order_status() {
        return open_order_status;
    }

    public void setOpen_order_status(boolean open_order_status) {
        this.open_order_status = open_order_status;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public static class Metadata{
        private String opid;
        private String source;
        private String carrier;
        private String shipvia;
       /* private boolean catchbox;
        private boolean consolidated_shipping;
        private boolean paperless_invoice;*/
        private String incoterms;

        public Metadata(String opid, String source, String carrier, String shipvia,/* boolean catchbox,
                        boolean consolidated_shipping, boolean paperless_invoice,*/ String incoterms) {
            this.opid = opid;
            this.source = source;
            this.carrier = carrier;
            this.shipvia = shipvia;
           /* this.catchbox = catchbox;
            this.consolidated_shipping = consolidated_shipping;
            this.paperless_invoice = paperless_invoice;*/
            this.incoterms = incoterms;
        }

        public Metadata() {
        }

        public String getOpid() {
            return opid;
        }

        public void setOpId(String opid) {
            this.opid = opid;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getCarrier() {
            return carrier;
        }

        public void setCarrier(String carrier) {
            this.carrier = carrier;
        }

        public String getShipvia() {
            return shipvia;
        }

        public void setShipvia(String shipvia) {
            this.shipvia = shipvia;
        }

      /*  public boolean isCatchbox() {
            return catchbox;
        }

        public void setCatchbox(boolean catchbox) {
            this.catchbox = catchbox;
        }

        public boolean isConsolidated_shipping() {
            return consolidated_shipping;
        }

        public void setConsolidated_shipping(boolean consolidated_shipping) {
            this.consolidated_shipping = consolidated_shipping;
        }

        public boolean isPaperless_invoice() {
            return paperless_invoice;
        }

        public void setPaperless_invoice(boolean paperless_invoice) {
            this.paperless_invoice = paperless_invoice;
        }*/

        public String getIncoterms() {
            return incoterms;
        }

        public void setIncoterms(String incoterms) {
            this.incoterms = incoterms;
        }

        @Override
        public String toString() {
            return "Metadata{" +
                    "opid='" + opid + '\'' +
                    ", source='" + source + '\'' +
                    ", carrier='" + carrier + '\'' +
                    ", shipvia='" + shipvia + '\'' +
                /*    ", catchbox=" + catchbox +
                    ", consolidated_shipping=" + consolidated_shipping +
                    ", paperless_invoice=" + paperless_invoice +*/
                    ", incoterms='" + incoterms + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "ShippingErrors{" +
                "_id='" + _id + '\'' +
                ", order='" + order + '\'' +
                ", lpn='" + lpn + '\'' +
                ", date_time=" + date_time +
                ", message='" + message + '\'' +
                ", error_code=" + error_code +
                ", location='" + location + '\'' +
                ", device_id=" + device_id +
                ", type='" + type + '\'' +
                ", open_order_status=" + open_order_status +
                ", metadata=" + metadata +
                ", closed_date=" + closed_date +
                '}';
    }
}
