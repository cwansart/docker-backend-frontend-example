OKPlugin_Toast = (() => {
  const Build = {
    toast: function (type) {
      const toast = document.createElement('div');
      const content = document.createElement('div');

      toast.classList.add('set:toast');
      content.classList.add('toast__content');

      if (type !== null) {
        toast.classList.add('set:toast--' + type);
      }

      toast.appendChild(content);
      return { toast: toast, content: content };
    },

    header: function (title) {
      const header = document.createElement('div');
      const titleDiv = document.createElement('div');
      const titleText = document.createTextNode(title);

      header.classList.add('toast__header');
      titleDiv.classList.add('title');

      titleDiv.appendChild(titleText);
      header.appendChild(titleDiv);

      return header;
    },

    body: function (message) {
      const body = document.createElement('div');

      body.classList.add('toast__body');
      body.appendChild(document.createTextNode(message));

      return body;
    },

    right: function (timeAgo, closeCallback) {
      const right = document.createElement('div');
      const time = document.createElement('div');
      const timeTextNode = document.createTextNode(timeAgo);
      const icon = document.createElement('i');

      right.classList.add('right');
      time.classList.add('time');
      icon.classList.add('fas');
      icon.classList.add('fa-times');

      icon.addEventListener('click', closeCallback);

      time.appendChild(timeTextNode);
      right.appendChild(time);
      right.appendChild(icon);

      return right;
    },
  };

  function OKPlugin_Toast ()
  {
    this.parent = null;
    this.defaultOptions = {
      title: "",
      message: "",
      timeAgo: "",
      type: null,
      callback: null,
    };
  }

  OKPlugin_Toast.prototype.init = function (okStyle)
  {
    okStyle.prototype.$toast = this.notify.bind(this);

    const parent = document.getElementById("set:toast-wrapper");
    if (this.parent === null) {
      const wrapper = document.createElement('div');
      wrapper.id = "set:toast-wrapper";

      this.parent = parent;
      this.parent = document.body.appendChild(wrapper);
    }
  };

  OKPlugin_Toast.prototype.notify = function (options)
  {
    options = Object.assign({}, this.defaultOptions, options);
    const toast = Build.toast(options.type);
    const header = Build.header(options.title);

    header.appendChild(Build.right(options.timeAgo, () => {
      if (typeof options.callback === "function") {
        options.callback();
      }

      toast.toast.classList.remove('set:toast--show');
      setTimeout(() => {
        toast.toast.remove();
      }, 400);
    }));

    toast.content.appendChild(header);
    toast.content.appendChild(Build.body(options.message));

    this.parent.appendChild(toast.toast);

    setTimeout(() => {
      toast.toast.classList.add('set:toast--show');
    }, 20);
  };

  return OKPlugin_Toast;
})();