const url = "http://localhost:8080/api";


/**
 * @param {string} endpoint - API endpoint 
 * @param {string} method - HTTP method 
 * @param {object} body - Request body 
 * @returns {Promise<any>} Response data
 */





export const fetchpath = async (endpoint, method = "get", body = null) => {
    try {


        const options = {
            method,
            headers: {
                "Content-Type": "application/json",
            },
        };

        if (body) {
            options.body = JSON.stringify(body);
        }

        const res = await fetch(`${url}${endpoint}`, options);

        if (!res.ok) {
            const err = await res.text();
            throw new Error(`Request failed: ${res.status} ${err}`);
        }

        const data = await res.json();

        return data;

    } catch (error) {
        console.log(error.message);
    }
};