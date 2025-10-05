// overall cart modal


import { useContext, useState } from "react";
import { CartContext } from "./CartContext";
import { FaShoppingCart } from "react-icons/fa";

import "./Cart.css";

export const Cart = () => {
  const { cart, removeFromCart, clearCart, decreaseQuantity, increaseQuantity , checkout} = useContext(CartContext);
  const [showCart, setShowCart] = useState(false);

  const total = cart.reduce((acc, item) => acc + item.price * item.quantity, 0);

  return (
    <div className="cart-container">
      <button className="cart-toggle-btn" onClick={() => setShowCart(!showCart)}>
        <FaShoppingCart size={20} />
        {cart.length>0 && <span className="cart-badge">{cart.length}</span>}
      </button>

      {showCart && (
        <div className="cart-popup">
          {cart.length === 0 ? (
            <div className="empty-cart">Your cart is empty</div>
          ) : (
            <>
              {cart.map(item => (
                <div className="cart-item" key={item.id}>
                  <img
                    className="cart-item-image"
                    src={`http://localhost:8080/${item.imageUrl}`}
                    alt={item.name}
                  />
                  <div className="cart-item-details">
                    <div className="cart-item-name">{item.name}</div>
                    <div className="cart-item-quantity">
                      <button className="qty-btn" onClick={() => increaseQuantity(item.id)}>+</button>
                      <span>{item.quantity}</span>
                      <button className="qty-btn" onClick={() => decreaseQuantity(item.id)}>−</button>
                    </div>
                    <div className="cart-item-price">₹{item.price.toFixed(2)}</div>
                  </div>
                  <button className="remove-item-btn" onClick={() => removeFromCart(item.id)}>Remove</button>
                </div>
              ))}

              <div className="cart-footer">
                <div className="cart-total">Total: ₹{total.toFixed(2)}</div>
                <div className="footer-actions">
                  <button className="checkout-btn" onClick={() =>checkout()}>Checkout</button>
                  <button className="clear-cart-btn" onClick={clearCart}>Clear Cart</button>
                </div>
              </div>
            </>
          )}
        </div>
      )}
    </div>
  );
};
