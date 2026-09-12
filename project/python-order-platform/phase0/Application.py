from dataclasses import dataclass


@dataclass(frozen=True)
class Order:
    order_id: str
    customer_id: str
    product_id: str
    quantity: int
    amount: float

class InventoryService:

    def is_available(self, order: Order) -> bool:
        print(f"Checking inventory for: {order.order_id}")
        return True

class FraudService:

    def is_safe(self, order: Order) -> bool:
        print(f"Running fraud check for: {order.order_id}")
        return True

class PaymentService:

    def process_payment(self, order: Order) -> None:
        print(f"Processing payment for: {order.order_id}")

class OrderProcessor:

    def __init__(
        self,
        inventory_service: InventoryService,
        fraud_service: FraudService,
        payment_service: PaymentService,
    ):
        self.inventory_service = inventory_service
        self.fraud_service = fraud_service
        self.payment_service = payment_service

    def process(self, order: Order) -> None:

        print(f"Processing order: {order.order_id}")

        if not self.inventory_service.is_available(order):
            raise RuntimeError("Inventory unavailable")

        if not self.fraud_service.is_safe(order):
            raise RuntimeError("Fraud detected")

        self.payment_service.process_payment(order)

        print(f"Order completed: {order.order_id}")


def main() -> None:

    processor = OrderProcessor(
        InventoryService(),
        FraudService(),
        PaymentService(),
    )

    order1 = Order(
        order_id="ORD-1001",
        customer_id="CUS-101",
        product_id="PRODUCT-1",
        quantity=1,
        amount=2500,
    )

    order2 = Order(
        order_id="ORD-1002",
        customer_id="CUS-102",
        product_id="PRODUCT-2",
        quantity=2,
        amount=4000,
    )

    processor.process(order1)
    processor.process(order2)


if __name__ == "__main__":
    main()