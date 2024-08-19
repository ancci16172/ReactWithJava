
export const useCookies = () => {
    const getCookie = (cookieName: string): {name : string,value : string} | null => {
        const name = `${cookieName}=`;
        const cookiesArray = document.cookie.split(';');

        for (let cookie of cookiesArray) {
            cookie = cookie.trim();
            if (cookie.indexOf(name) === 0) {
                const cookieValue = cookie.substring(name.length, cookie.length);
                return {
                    name : cookieName,
                    value : cookieValue
                }
            }
        }
        return null;
    };

    const deleteCookie = (cookieName : string) =>{
         document.cookie = cookieName + '=; Max-Age=0';
    }

    return {
        getCookie,
        deleteCookie
    }
}

