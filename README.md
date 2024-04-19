# AltiusHubTest
## Invoice 
### Database Design Relations : 
InvoiceHeader to InvoiceItem: One-to-Many. An invoice can have multiple items.
InvoiceHeader to InvoiceBillSundry: One-to-Many. An invoice can have multiple sundries.

*Note: Auto incremental of invoice number and its uniqueness is not implemented*
### MYSql database Used
### Payload
{
    "id": "auto-generated",
    "date": "2024-04-19T00:00:00Z",
    "customerName": "Jane Smith",
    "billingAddress": "4321 abani dutta road, kolkata",
    "shippingAddress": "8765 rajarhat main Rd, kolkata, OT",
    "gstin": "22AAAAA0000A1Z5",
    "totalAmount": 1260.00,
    "invoiceItems": [
        {
            "itemName": "Widget",
            "quantity": 5,
            "price": 100.00,
            "amount": 500.00
        },
        {
            "itemName": "Gadget",
            "quantity": 4,
            "price": 50.00,
            "amount": 200.00
        },
        {
            "itemName": "New Item",
            "quantity": 3,
            "price": 120.00,
            "amount": 360.00
        }
    ],
    "invoiceBillSundries": [
        {
            "billSundryName": "Handling",
            "amount": 200.00
        }
    ]
}

