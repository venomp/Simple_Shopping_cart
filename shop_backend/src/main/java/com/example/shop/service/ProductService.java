
package com.example.shop.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.shop.dto.ProductDTO;
import com.example.shop.model.ProductEntity;

@Service
public class ProductService {
        private final List<ProductEntity> products = new ArrayList<>();

        public ProductService() {
                
                products.add(new ProductEntity(1L, "ALKETRON Icecube T100 Desktop",
                                33600,
                                "images/cpu/ALKETRON_icecube_T100.jpg",
                                "Compact high-performance desktop PC with efficient cooling and quiet operation."));

                products.add(new ProductEntity(2L, "Ant PC Argentine AL14400 Desktop",
                                38639,
                                "images/cpu/Ant_PC_Argentine_AL14400.jpg",
                                "Gaming-ready desktop featuring the latest Intel processor and sleek design."));

                products.add(new ProductEntity(3L, "MSI MAG Forge Desktop",
                                36019,
                                "images/cpu/MSI_MAG_Forge.jpg",
                                "Powerful workstation PC ideal for gaming, streaming, and content creation."));

                products.add(new ProductEntity(4L, "NXTGN Desktop",
                                32759,
                                "images/cpu/NXTGN.jpg",
                                "Next-generation desktop with balanced performance for everyday computing."));

                products.add(new ProductEntity(5L, "Ant Esports MK801 V2 Pro Keyboard",
                                7560,
                                "images/keyboard/Ant_Esports_MK801_V2_Pro.jpg",
                                "Mechanical gaming keyboard with RGB lighting and durable switches."));

                products.add(new ProductEntity(6L, "Cosmic Byte CB-GK-27 Keyboard",
                                6720,
                                "images/keyboard/Cosmic_Byte_CB-GK-27.jpg",
                                "Compact mechanical keyboard offering smooth keys and vibrant backlight."));

                products.add(new ProductEntity(7L, "Logitech G915 X Keyboard",
                                16800,
                                "images/keyboard/Logitech_G915_X.jpg",
                                "Ultra-thin wireless mechanical keyboard with long battery life and low-latency response."));

                products.add(new ProductEntity(8L, "Razer Ornata V3 Keyboard",
                                9240,
                                "images/keyboard/Razer_Ornata_V3.jpg",
                                "Hybrid mechanical keyboard with soft cushioned keys and Chroma RGB effects."));

                products.add(new ProductEntity(9L, "Acer EK220Q Monitor",
                                13439,
                                "images/monitor/Acer_EK220Q.jpg",
                                "21.5-inch Full HD monitor with sharp visuals and flicker-less display."));

                products.add(new ProductEntity(10L, "Lenovo Legion R25f-30 Monitor",
                                15959,
                                "images/monitor/Lenovo_Legion_R25f-30.jpg",
                                "24.5-inch gaming monitor with high refresh rate and fast response time."));

                products.add(new ProductEntity(11L, "LG Ultragear Monitor",
                                18479,
                                "images/monitor/LG_Ultragear.jpg",
                                "27-inch IPS gaming monitor with stunning colors and G-SYNC compatibility."));

                products.add(new ProductEntity(12L, "Samsung 24\" Monitor",
                                15119,
                                "images/monitor/Samsung_24.jpg",
                                "24-inch curved monitor offering immersive visuals and crisp Full HD clarity."));

                products.add(new ProductEntity(13L, "Dell MS116 Mouse",
                                2099,
                                "images/mouse/Dell_MS116.jpg",
                                "Reliable wired optical mouse with precise tracking for everyday use."));

                products.add(new ProductEntity(14L, "Logitech G304 Mouse",
                                4199,
                                "images/mouse/Logitech_G304.jpg",
                                "Wireless gaming mouse with HERO sensor and ultra-long battery life."));

                products.add(new ProductEntity(15L, "Razer Cobra Mouse",
                                5880,
                                "images/mouse/Razer_Cobra.jpg",
                                "Lightweight gaming mouse with customizable Chroma RGB lighting."));

                products.add(new ProductEntity(16L, "Zebronics War M Mouse",
                                2520,
                                "images/mouse/Zebronics_war_m.jpg",
                                "Ergonomic wired gaming mouse with adjustable DPI settings."));

                products.add(new ProductEntity(17L, "Sounce Large Mousepad",
                                1260,
                                "images/mousepad/Sounce_large_mousepad.jpg",
                                "Extended non-slip mousepad providing smooth glide for gaming or work."));

                products.add(new ProductEntity(18L, "Spin Cart Mousepad",
                                1092,
                                "images/mousepad/Spin_Cart_mousepad.jpg",
                                "Durable cloth surface mousepad with stitched edges for longevity."));

                products.add(new ProductEntity(19L, "Tee Mafia Mousepad",
                                1176,
                                "images/mousepad/Tee_mafia_mousepad.jpg",
                                "Stylish printed mousepad offering precise tracking and soft comfort."));

                products.add(new ProductEntity(20L, "Zebronics Firestorm Mousepad",
                                1344,
                                "images/mousepad/Zebronics_firestorm_Mousepad.jpg",
                                "High-grip gaming mousepad with smooth surface for fast mouse movement."));
        }

        // get all products as dto 
        public List<ProductDTO> getAllProducts() {
                return products.stream()
                                .map(p -> new ProductDTO(
                                                p.getId(),
                                                p.getName(),
                                                p.getPrice(),
                                                p.getImageUrl(),
                                                p.getDescription()))
                                .collect(Collectors.toList());
        }
}
