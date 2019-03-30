OKPlugin_Collapse = (() => {
  const CollapseItem = function ()
  {
    this.maxHeight = 0;
    this.header = null;
    this.content = null;
    this.shown = false;
  };

  CollapseItem.prototype.handler = function () {
    this.content.style.maxHeight = this.shown ? "0px" : this.maxHeight + "px";
    this.shown = !this.shown;
  };

  CollapseItem.prototype.init = function (doc) {
    this.header = doc.children.item(0);
    this.content = doc.children.item(1);
    this.maxHeight = this.content.scrollHeight;

    this.content.style.maxHeight = "0px";
    this.header.addEventListener('click', this.handler.bind(this));

    return this;
  };

  function OKPlugin_Collapse()
  {
    this.selector = "set:collapse";
    this.docs = [];
  }

  OKPlugin_Collapse.prototype.init = function ()
  {
    let  docs = document.getElementsByClassName(this.selector);
    docs = Object.keys(docs).map((idx) => {
      return new CollapseItem().init(docs[idx]);
    });

    this.docs = docs;
  }

  return OKPlugin_Collapse;
})();