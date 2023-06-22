This project is using kafka with spring cloud kafka binder to 
showcase kafka streaming.

In this case, a producer is producing messages and sending them to the `input` topic , a stream processor is transforming
it and then sending it to an `output` topic.