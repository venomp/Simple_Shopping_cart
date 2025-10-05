// modal to display product in details and add to cart


import { useContext } from "react";
import "./ProductModal.css";
import { CartContext } from "../cart/CartContext";

export const ProductModal = ({ product, onClose }) => {

  const {addToCart} = useContext(CartContext);
  return (
    <div className="modal-overlay">
      <div className="modal-content">
        <button className="modal-close" onClick={onClose}>✖</button>
        
        <div className="modal-body">
          <img
            className="modal-image"
            src={`http://localhost:8080/${product.imageUrl}`}
            alt={product.name}
          />
          <div className="modal-details">
            <h2>{product.name}</h2>
            <p className="modal-description">{product.description}</p>
            <p className="modal-price">₹{product.price.toFixed(2)}</p>
            <button className="add-to-cart-btn" onClick={()=>addToCart(product)}>Add to Cart</button>
          </div>
        </div>
      </div>
    </div>
  );
};
